package com.tracelijing.tlibrary;

/**
 * Created by Trace (Tapatalk) on 2016/3/23.
 */

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 获取手机信息工具类
 *
 */
public class PhoneUtil {

	private static PhoneUtil instance;

	private TelephonyManager tm;
	private Activity act;

	private PhoneUtil(Activity act) {
		tm = (TelephonyManager) act.getSystemService(Context.TELEPHONY_SERVICE);
		this.act = act;
	}

	public static PhoneUtil getInstance(Activity act) {
		if (instance == null) {
			instance = new PhoneUtil(act);
		} else if (instance.act != act) {
			instance = new PhoneUtil(act);
		}
		return instance;
	}

	/**
	 * 是否处于飞行模式
	 */
	public boolean isAirModeOpen() {
		return (Settings.System.getInt(act.getContentResolver(),
				Settings.System.AIRPLANE_MODE_ON, 0) == 1 ? true : false);
	}

	/**
	 * 获取手机号码
	 */
	public String getPhoneNumber() {
		return tm == null ? null : tm.getLine1Number();
	}

	/**
	 * 获取网络类型（暂时用不到）
	 */
	public int getNetWorkType() {
		return tm == null ? 0 : tm.getNetworkType();
	}

	/**
	 * 获取手机sim卡的序列号（IMSI）
	 */
	public String getIMSI() {
		return tm == null ? null : tm.getSubscriberId();
	}

	/**
	 * 获取手机IMEI
	 */
	public String getIMEI() {
		return tm == null ? null : tm.getDeviceId();
	}

	/**
	 * 获取手机型号
	 */
	public static String getModel() {
		return android.os.Build.MODEL;
	}

	/**
	 * 获取手机品牌
	 */
	public static String getBrand() {
		return android.os.Build.BRAND;
	}

	/**
	 * 获取手机系统版本
	 */
	public static String getVersion() {
		return android.os.Build.VERSION.RELEASE;
	}

	/**
	 * 获得手机系统总内存
	 */
	public String getTotalMemory() {
		String str1 = "/proc/meminfo";// 系统内存信息文件
		String str2;
		String[] arrayOfString;
		long initial_memory = 0;

		try {
			FileReader localFileReader = new FileReader(str1);
			BufferedReader localBufferedReader = new BufferedReader(
					localFileReader, 8192);
			str2 = localBufferedReader.readLine();// 读取meminfo第一行，系统总内存大小

			arrayOfString = str2.split("\\s+");

			initial_memory = Integer.valueOf(arrayOfString[1]).intValue() * 1024;// 获得系统总内存，单位是KB，乘以1024转换为Byte
			localBufferedReader.close();

		} catch (IOException e) {
		}
		return Formatter.formatFileSize(act, initial_memory);// Byte转换为KB或者MB，内存大小规格化
	}

	/**
	 * 获取手机屏幕宽
	 */
	public int getScreenWidth() {
		return act.getWindowManager().getDefaultDisplay().getWidth();
	}

	/**
	 * 获取手机屏高宽
	 */
	public int getScreenHeight() {
		return act.getWindowManager().getDefaultDisplay().getHeight();
	}

	/**
	 * 获取应用包名
	 */
	public String getPackageName() {
		return act.getPackageName();
	}

	/**
	 * 获取手机MAC地址
	 * 只有手机开启wifi才能获取到mac地址
	 */
	public String getMacAddress() {
		String result = "";
		WifiManager wifiManager = (WifiManager) act.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		result = wifiInfo.getMacAddress();
		return result;
	}

	/**
	 * 获取手机CPU信息 //1-cpu型号  //2-cpu频率
	 */
	public String[] getCpuInfo() {
		String str1 = "/proc/cpuinfo";
		String str2 = "";
		String[] cpuInfo = {"", ""};  //1-cpu型号  //2-cpu频率
		String[] arrayOfString;
		try {
			FileReader fr = new FileReader(str1);
			BufferedReader localBufferedReader = new BufferedReader(fr, 8192);
			str2 = localBufferedReader.readLine();
			arrayOfString = str2.split("\\s+");
			for (int i = 2; i < arrayOfString.length; i++) {
				cpuInfo[0] = cpuInfo[0] + arrayOfString[i] + " ";
			}
			str2 = localBufferedReader.readLine();
			arrayOfString = str2.split("\\s+");
			cpuInfo[1] += arrayOfString[2];
			localBufferedReader.close();
		} catch (IOException e) {
		}
		return cpuInfo;
	}

	/**
	 * 获取Application中的meta-data内容
	 */
	public String getMetaData(String name) {
		String result = "";
		try {
			ApplicationInfo appInfo = act.getPackageManager()
					.getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
			result = appInfo.metaData.getString(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
