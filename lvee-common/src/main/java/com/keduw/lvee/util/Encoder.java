package com.keduw.lvee.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Encoder {

	private static Logger Log =  (Logger) LoggerFactory.getLogger(Encoder.class);

	private Encoder() {
		throw new AssertionError();
	}

	/**
	 * encode to url string
	 * @param url original string
	 * @return encoded url string
	 */
	public static String encodeUrl(String url) {
		if (url == null) {
			return "";
		}

		StringBuilder buf = new StringBuilder(100);
		encodeUrl(url, buf);
		return buf.toString();
	}

	/**
	 * encode to url string
	 * @param url original string
	 * @param buf encoded string builder
	 */
	public static void encodeUrl(String url, StringBuilder buf) {
		if (url == null) {
			return;
		}
		try {
			buf.append(URLEncoder.encode(url, "UTF-8"));
		} catch (Exception e) {
		}
	}

	/**
	 * encode to url string
	 * @param url original string
	 * @param enc format, like UTF-8
	 * @return encoded url string
	 */
	public static String encodeUrl(String url, String enc) {
		if (url == null) {
			return "";
		}
		try {
			return URLEncoder.encode(url, enc);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * decode from url string
	 * @param url encoded url string
	 * @param enc format, like UTF-8
	 * @return original string
	 */
	public static String decodeUrl(String url, String enc) {
		if (url == null) {
			return "";
		}
		try {
			return URLDecoder.decode(url, enc);
		} catch (Exception e) {
		}
		return "";
	}
	
	/**
	 * decode from base 64 string
	 * @param base64 encoded string
	 * @return original string
	 */
	public static byte[] decodeBase64(String base64, boolean isLog) {
		try {
			return Base64.decode(base64);
			//sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			//return decoder.decodeBuffer(base64);
		} catch (Exception exp) {
			if(isLog){
				Log.error("decodeBase64 err", exp);
			}
			return null;
		}
	}


	/**
	 * 把字符串转为写在html中的字符串，如&->&amp;
	 * @param html original string
	 * @return html string
	 */
	public static String encodeHtml(String html) {
		if (html == null) {
			return "";
		}
		StringBuilder buf = new StringBuilder(html.length() * 3); // 预留3倍空间，一般情况下够了
		encodeHtml(html, buf);
		return buf.toString();
	}

	/**
	 * 把字符串转为写在html中的字符串，如&->&amp; 
	 * @param html original string
	 * @param buf string builder
	 */
	public static void encodeHtml(String html, StringBuilder buf) {
		try {
			if (html == null) {
				return;
			}
			int spaceCount = 0;						// 词/字间 空格数计算器
			int len = html.length();
			for (int i = 0; i < len; ++i) {
				char c = html.charAt(i);
				
				// 新加, 对于连续空格，第一个空格不处理
				if(c == ' ') {						// 遇到空格 计算器+1
					spaceCount++;
				}else{								// 非空格 计算器重置为0
					spaceCount = 0;
				}
				
				switch (c) {
				case '&': {
					buf.append("&amp;");
					break;
				}
				//解决场景：比如</div>word       hei</div>这个在浏览器识别word与hei之间只识别一个空格，所以导致用户输入多个空格无效
				//解决办法：将空格转为&nbsp;
				case ' ': {
					if(spaceCount < 2){				// 第一个空格不处理
						buf.append(c);
						break;
					}
					buf.append("&nbsp;");
					break;
				}
				case '<': {
					buf.append("&lt;");
					break;
				}
				case '>': {
					buf.append("&gt;");
					break;
				}
				case '\'': {
					buf.append("&#39;");
					break;
				}
				case '\\': {
					buf.append("&#92;");
					break;
				}
				case '"': {
					buf.append("&quot;");
					break;
				}
				case '\n': {
					buf.append("<br/>");
					break;
				}
				case '\r': {
					break;
				}
				case '\t': {
					break;
				}
				default: {
					buf.append(c);
				}
				}
			}
		} catch (Exception e) {
			buf.setLength(0);
		}
	}
	
	
	public static String encodeLine(String html){
		if (html == null) {
			return "";
		}
		StringBuilder buf = new StringBuilder(html.length() * 3); // 预留3倍空间，一般情况下够了
		encodeLine(html, buf);
		return buf.toString();
	}
	
	/**
	 * 把字符串转为只输出一行的字符串（换行转空格），如&->&amp; 
	 * @param html original string
	 * @param buf string builder
	 */
	public static void encodeLine(String html, StringBuilder buf) {
		try {
			if (html == null) {
				return;
			}
			int len = html.length();
			for (int i = 0; i < len; ++i) {
				char c = html.charAt(i);
				switch (c) {
				case '\n':
				case '\r':
				case '\t': {
					buf.append(" ");
					break;
				}
				default: {
					buf.append(c);
				}
				}
			}
		} catch (Exception e) {
			buf.setLength(0);
		}
	}

	/**
	 * 把字符串转换为写在html中属性值，例如<div title="xxx">
	 * @param html original string
	 * @return html attribute string
	 */
	public static String encodeHtmlAttr(String html) {
		if (html == null) {
			return "";
		}
		StringBuilder buf = new StringBuilder(html.length() * 3); // 预留3倍空间，一般情况下够了
		encodeHtmlAttr(html, buf);
		return buf.toString();
	}

	/**
	 * 把字符串转换为写在html中属性值，例如<div title="xxx">
	 * encode规则：‘符号’ -> '&#x' + 符号的ASCII编码16进制值 + ';'
	 * @param html original string
	 * @param buf attribute string builder
	 */
	public static void encodeHtmlAttr(String html, StringBuilder buf) {
		try {
			if (html == null) {
				return;
			}
			int len = html.length();
			for (int i = 0; i < len; ++i) {
				char c = html.charAt(i);
				switch (c) {
				case '"': {
					buf.append("&#x22;");
					break;
				}
				case '\'': {
					buf.append("&#x27;");
					break;
				}
				case '<': {
					buf.append("&#x3c;");
					break;
				}
				case '>': {
					buf.append("&#x3e;");
					break;
				}
				case '&': {
					buf.append("&#x26;");
					break;
				}
				case '\\': {
					buf.append("&#x5c;");
					break;
				}
				/*
				case '%': {
					buf.append("&#x25");
					break;
				}
				case '/': {
					buf.append("&#x2f");
					break;
				}
				*/
				default: {
					buf.append(c);
				}
				}
			}
		} catch (Exception e) {
			buf.setLength(0);
		}
	}
	
	/**
	 * 将转义html代码转会html
	 * @param html
	 * @return
	 */
	public static String decodeHtml(String html){
		try{
		return html.replaceAll("&nbsp;", " ").replaceAll("&lt;", "<").replaceAll("&gt;", ">")
				.replaceAll("&#92;", "\\\\").replaceAll("&#39;", "\'").replaceAll("&quot;", "\"").replaceAll("<br/>", "\n").replaceAll("&amp;", "&");
		} catch(Exception e){
			return "";
		}
	}

	private static String toBase64Url(String base64) {
		int len = base64.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; ++i) {
			char c = base64.charAt(i);
			if (c == '+') {
				// 由于符号"*"在某些邮箱中，会被过滤掉，这里采用用于URL的改进Base64变种，把"+"替换成"_"
				//sb.append('*');
				sb.append('_');
			} else if (c == '/') {
				sb.append('-');
			} else if (c == '=') {
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}