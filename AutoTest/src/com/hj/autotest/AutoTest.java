package com.hj.autotest;

import java.io.File;

import android.os.RemoteException;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AutoTest extends UiAutomatorTestCase {

	public static void main(String[] args) {
		new UiAutomatorTool("Demo", "com.hj.autotest.AutoTest", "testDevice", "30");
	}

	public void testAll() throws UiObjectNotFoundException {
		UiDevice.getInstance().pressHome();
		new UiObject(new UiSelector().description("Apps"))
				.clickAndWaitForNewWindow();
		UiScrollable scrollable = new UiScrollable(
				new UiSelector()
						.resourceId("com.google.android.googlequicksearchbox:id/apps_customize_pane_content"));
		scrollable.setAsHorizontalList();
		UiObject word = new UiObject(new UiSelector().text("沪江开心词场"));
		while (!word.exists()) {
			scrollable.scrollForward();
		}
		word.clickAndWaitForNewWindow();
		UiObject username = new UiObject(new UiSelector().text("沪江用户名/邮箱/手机"));
		username.setText("xys10086");
		sleep(1000);
		UiObject pwd = new UiObject(
				new UiSelector().resourceId("com.hjwordgames:id/edit_password"));
		pwd.setText("Aa123465");
		sleep(1000);
		UiObject login = new UiObject(new UiSelector().text("登 录"));
		login.clickAndWaitForNewWindow();
		if (new UiObject(new UiSelector().className(
				"android.widget.FrameLayout").index(1)).exists()) {
			new UiObject(new UiSelector().text("注册"))
					.clickAndWaitForNewWindow();
			new UiObject(
					new UiSelector()
							.resourceId("com.hjwordgames:id/registerEditUsername"))
					.setText("xys100861");
			new UiObject(
					new UiSelector()
							.resourceId("com.hjwordgames:id/registerEditPassword"))
					.setText("Aa123456");
			new UiObject(
					new UiSelector()
							.resourceId("com.hjwordgames:id/regiserEditEmail"))
					.setText("35998151@qq.com");
			new UiObject(new UiSelector().text("确认注册"))
					.clickAndWaitForNewWindow();
			UiObject ok = new UiObject(
					new UiSelector().resourceId("com.hjwordgames:id/btnOK"));
			if (ok.waitForExists(500)) {
				ok.clickAndWaitForNewWindow();
			}
		}

	}

	public void testUiScrollable() throws UiObjectNotFoundException {
		UiScrollable scrollable = new UiScrollable(
				new UiSelector().className("android.widget.ListView"));
		scrollable.flingForward();
		sleep(500);
		scrollable.flingBackward();
		sleep(500);
		scrollable.flingForward();
		UiObject target = new UiObject(new UiSelector().text("德国工业就是这么强大！不得不服"));
		scrollable.scrollIntoView(target);
		target.click();
	}

	public void testUiSelector() throws UiObjectNotFoundException {
		UiObject word = new UiObject(new UiSelector().text("沪江开心词场"));
		word.clickAndWaitForNewWindow();
		UiObject username = new UiObject(new UiSelector().text("沪江用户名/邮箱/手机"));
		username.setText("xuyisheng");
		sleep(1000);
		UiObject pwd = new UiObject(
				new UiSelector().resourceId("com.hjwordgames:id/edit_password"));
		pwd.setText("123465");
		sleep(2000);
		pwd.clearTextField();
		sleep(1000);
		pwd.setText("123465");
		UiDevice.getInstance().pressBack();
		sleep(1000);
		UiObject login = new UiObject(new UiSelector().text("登 录"));
		login.clickAndWaitForNewWindow();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		word.dragTo(300, 300, 50);
		sleep(1000);
		word.swipeDown(50);
	}

	public void testDevice() throws UiObjectNotFoundException, RemoteException {
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		sleep(1000);
		UiDevice.getInstance().pressMenu();
		sleep(1000);
		UiDevice.getInstance().pressBack();
		sleep(1000);
		UiDevice.getInstance().pressRecentApps();
		sleep(1000);
		UiDevice.getInstance().pressHome();
		sleep(1000);
		UiDevice.getInstance().click(240, 1100);
		sleep(2000);
		UiDevice.getInstance().click(670, 1100);
		sleep(2000);
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_H);
		sleep(1000);
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_H, 1);
		sleep(1000);
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_J);
		sleep(1000);
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_J, 1);
		sleep(1000);
		UiDevice.getInstance().swipe(30, 400, 600, 400, 10);
		sleep(1000);
		UiDevice.getInstance().pressHome();
		sleep(1000);
		UiDevice.getInstance().drag(660, 860, 360, 360, 50);
		sleep(1000);
		UiDevice.getInstance().sleep();
		sleep(1000);
		UiDevice.getInstance().wakeUp();
		sleep(1000);
		UiDevice.getInstance().swipe(370, 1000, 370, 200, 50);
		sleep(1000);
		UiDevice.getInstance().takeScreenshot(new File("/sdcard/uidevice.png"));
	}
}
