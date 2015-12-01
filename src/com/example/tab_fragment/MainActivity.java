package com.example.tab_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements OnClickListener {

	// Tab
	private LinearLayout mLayoutWeChat;
	private LinearLayout mLayoutFriend;
	private LinearLayout mLayoutContanct;
	private LinearLayout mLayoutSetting;

	// ImageButton
	private ImageButton mImgBtnWeChat;
	private ImageButton mImgBtnFriend;
	private ImageButton mImgBtnContanct;
	private ImageButton mImgBtnSetting;

	// Fragment
	private Fragment mFragmentWechat;
	private Fragment mFragmentFriend;
	private Fragment mFragmentContant;
	private Fragment mFragmentSetting;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initView();
		initEvent();
		setSelect(0);
	}

	private void initEvent() {
		mLayoutWeChat.setOnClickListener(this);
		mLayoutFriend.setOnClickListener(this);
		mLayoutContanct.setOnClickListener(this);
		mLayoutSetting.setOnClickListener(this);
	}

	private void initView() {

		mLayoutWeChat = (LinearLayout) findViewById(R.id.btn_wechat);
		mLayoutFriend = (LinearLayout) findViewById(R.id.btn_friend);
		mLayoutContanct = (LinearLayout) findViewById(R.id.btn_contanct);
		mLayoutSetting = (LinearLayout) findViewById(R.id.btn_setting);

		mImgBtnWeChat = (ImageButton) findViewById(R.id.iv_wechat);
		mImgBtnFriend = (ImageButton) findViewById(R.id.iv_friend);
		mImgBtnContanct = (ImageButton) findViewById(R.id.iv_contanct);
		mImgBtnSetting = (ImageButton) findViewById(R.id.iv_setting);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_wechat:
			setSelect(0);
			break;
		case R.id.btn_friend:
			setSelect(1);
			break;
		case R.id.btn_contanct:
			setSelect(2);
			break;
		case R.id.btn_setting:
			setSelect(3);
			break;

		default:
			break;
		}
	}

	private void setSelect(int i) {

		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		hideFragment(transaction);
		resetImg();

		switch (i) {
		case 0:
			if (mFragmentWechat == null) {
				mFragmentWechat = new WeChatFragment();
				transaction.add(R.id.content, mFragmentWechat);
			} else {
				transaction.show(mFragmentWechat);
			}
			mImgBtnWeChat.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case 1:

			if (mFragmentFriend == null) {
				mFragmentFriend = new FriendFragment();
				transaction.add(R.id.content, mFragmentFriend);
			} else {
				transaction.show(mFragmentFriend);
				transaction.replace(R.id.content, mFragmentFriend);
			}

			mImgBtnFriend.setImageResource(R.drawable.tab_find_frd_pressed);

			break;
		case 2:

			if (mFragmentContant == null) {
				mFragmentContant = new ContantFragment();
				transaction.add(R.id.content, mFragmentContant);
			} else {
				transaction.show(mFragmentContant);
			}

			mImgBtnContanct.setImageResource(R.drawable.tab_address_pressed);

			break;
		case 3:
			if (mFragmentSetting == null) {
				mFragmentSetting = new SettingFragment();
				transaction.add(R.id.content, mFragmentSetting);
			} else {
				transaction.show(mFragmentSetting);
			}
			mImgBtnSetting.setImageResource(R.drawable.tab_settings_pressed);
			break;

		default:
			break;
		}
		transaction.commit();
	}

	private void hideFragment(FragmentTransaction transaction) {

		if (mFragmentWechat != null) {
			transaction.hide(mFragmentWechat);
		}
		if (mFragmentFriend != null) {
			transaction.hide(mFragmentFriend);
		}
		if (mFragmentContant != null) {
			transaction.hide(mFragmentContant);
		}
		if (mFragmentSetting != null) {
			transaction.hide(mFragmentSetting);
		}

	}

	// ½«ËùÓÐÍ¼Æ¬ÇÐ»»ÖÁÎ´µã»÷×´Ì¬
	private void resetImg() {
		mImgBtnWeChat.setImageResource(R.drawable.tab_weixin_normal);
		mImgBtnFriend.setImageResource(R.drawable.tab_find_frd_normal);
		mImgBtnContanct.setImageResource(R.drawable.tab_address_normal);
		mImgBtnSetting.setImageResource(R.drawable.tab_settings_normal);
	}
}
