package com.hj.autotest;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AutoTest extends UiAutomatorTestCase {

	public static void main(String[] args) {
		new UiAutomatorTool("Demo", "com.hj.autotest.AutoTest", "testBrowser",
				"30");
	}

	public void testBrowser() throws UiObjectNotFoundException {
		UiDevice.getInstance().pressHome();
		UiObject browser = new UiObject(new UiSelector().text("Browser"));
		browser.clickAndWaitForNewWindow();
		UiObject edit = new UiObject(
				new UiSelector().className("android.widget.EditText"));
		edit.click();
		UiDevice.getInstance().pressDelete();
		edit.setText("www.hujiang.com");
		UiDevice.getInstance().pressEnter();
	}
}
