package jianqiang.com.core.engine;

import android.content.res.XmlResourceParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

import jianqiang.com.core.R;

public class ProductConfigManager {
	private static HashMap<String, Boolean> configList;
	private static HashMap<String, String> mapList;

	public static void fetchConfigDataFromXml() {
		configList = new HashMap<String, Boolean>();
		mapList = new HashMap<String, String>();

		getConfig(R.xml.feature_config_default);
		getConfig(R.xml.feature_config);
	}

	static void getConfig(int xmlResourceId) {

		String name = null;
		String map = null;

		final XmlResourceParser xmlParser = GlobalApplication.getContextObject()
				.getResources().getXml(xmlResourceId);

		int eventCode;
		try {
			eventCode = xmlParser.getEventType();
			while (eventCode != XmlPullParser.END_DOCUMENT) {
				switch (eventCode) {
					case XmlPullParser.START_DOCUMENT:
						break;
					case XmlPullParser.START_TAG:
						if ("Page".equals(xmlParser.getName())) {
							name = xmlParser.getAttributeValue(null, "name");
							map = xmlParser.getAttributeValue(null, "map");

							mapList.put(name, map);
						} else if("Node".equals(xmlParser.getName())) {
							final String key = xmlParser.getAttributeValue(null, "key");
							final String value = xmlParser.getAttributeValue(null, "value");

							configList.put(name + key, new Boolean(value));
						}
						break;
					case XmlPullParser.END_TAG:
						break;
					default:
						break;
				}
				eventCode = xmlParser.next();
			}
		} catch (final XmlPullParserException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			xmlParser.close();
		}
	}

	public static boolean findConfig(final String key) {
		// 如果configList还没有数据（第一次），或者被回收了，那么（重新）加载xml
		if (configList == null || configList.isEmpty())
			fetchConfigDataFromXml();

		return configList.get(key);
	}

	public static String findMap(final String key) {
		// 如果configList还没有数据（第一次），或者被回收了，那么（重新）加载xml
		if (mapList == null || mapList.isEmpty())
			fetchConfigDataFromXml();

		return mapList.get(key);
	}
}