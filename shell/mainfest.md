```
		  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f 
00000000h:03 00 08 00 ac ab 00 00 01 00 1c 00 88 4e 00 00
```

magic number      :0x00080003

文件大小                :0x0000ABAC (43948个字节)

### StringChunk

StringChunk标识  :0x001C0001

StringChunk大小  :0x00004E88(20104个字节)，区间为(0x00000008-0x00004E8F)

```
		   0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f 
00000010h: 17 01 00 00 00 00 00 00 00 00 00 00 78 04 00 00
```

0x00000010字符串个数          :0x00000117(**279**个)(0x00000010 开始的 4 个字节)。一共**279**个字符串。

0x00000014 开始处的 4 个字节内容为 Style 个数,
至于 Style 为何物,因为找了很多 APK,发现该处的值始终为 0x00000000,也就是没有 Style
内容,
所以暂时无法确定 Style 具体意思。

0x00000018 开始处的 4 个字节内容为 unKnown,发现该处的值始终为 0x00000000.

这些字符串存放
在相对于 StringChunk 开头偏移量为 0x00000478(0x0000001C 处的 4 个字节内容)的地方,即
0x00000008 + 0x0000000478 = 0x00000480。

```
		   0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f 
00000020h: 00 00 00 00 00 00 00 00 1a 00 00 00 34 00 00 00
```



0x00000020 开始处的 4 字节内容为 Style 内容相对于 String Chunk 开
头位置的偏移量,因为 Style 个数为 0,所以此处的值为 0x00000000。



从 0x00000024 位置
开始,后面连续跟着 **279** 个字符串的偏移量(相对于字符串内容的起始位置,在本次分析的
AndroidManifest 中即为 0x00000460)

每个字符的偏移量占4个字节：279*4=1116=0x0000045C

0x00000024 +　0x0000045C= 0x00000480

```
		  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f 
00000480h:0b 00 76 00 65 00 72 00 73 00 69 00 6f 00 6e 00
00000490h:43 00 6f 00 64 00 65 00 00 00 0b 00 76 00 65 00
000004a0h:72 00 73 00 69 00 6f 00 6e 00 4e 00 61 00 6d 00
000004b0h:65 00 00 00 11 00 63 00 6f 00 6d 00 70 00 69 00
```

第一个字符串偏移量当然为 0 了,起始位置为0x0000480;

字符长度为２个字节:0x0b(11)个字符(最大长度为255个字符)，结束符占用2个字节，

每个字符占用2个字节,一共占用0x001A(26)个字节结束位置为0x000049A

:0x0076(v),0x0065(e),0x0072(r),0x0073(s),0x0069(i),0x006F(o),0x006E(n),0x0043(C),0x006F(o),0x0064(d),0x0065(e) 

versionCode

第二个字符串偏移量为0x0000001A,第二个字符串开始
位置为 0x00000480+0x0000001A=0x0000049A。



```
	      0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f 
00004e70h:74 00 69 00 76 00 69 00 74 00 79 00 00 00 07 00
00004e80h:61 00 6e 00 64 00 72 00 6f 00 69 00 64 00 00 00
```

第279个字符串偏移量为0x000049FE;开始位置为 0x00000480+0x000049FE=0x00004E7E。

字符串长度为2个字节:0x0007(7)个，结束符占用2个字节，每个字符占用2个字节,一共占用0x12(18)个字节结束位置为0x00004E90:0x0061(a),0x006E(n),0x0064(d),0x0072(r),0x006F(o),0x0069(i),0x0064(d)

android

```
parseStringContentList i:0;Str:versionCode
parseStringContentList i:1;Str:versionName
parseStringContentList i:2;Str:compileSdkVersion
parseStringContentList i:3;Str:compileSdkVersionCodename
parseStringContentList i:4;Str:minSdkVersion
parseStringContentList i:5;Str:targetSdkVersion
parseStringContentList i:6;Str:name
parseStringContentList i:7;Str:protectionLevel
parseStringContentList i:8;Str:theme
parseStringContentList i:9;Str:label
parseStringContentList i:10;Str:icon
parseStringContentList i:11;Str:allowBackup
parseStringContentList i:12;Str:hardwareAccelerated
parseStringContentList i:13;Str:largeHeap
parseStringContentList i:14;Str:supportsRtl
parseStringContentList i:15;Str:usesCleartextTraffic
parseStringContentList i:16;Str:networkSecurityConfig
parseStringContentList i:17;Str:appComponentFactory
parseStringContentList i:18;Str:requestLegacyExternalStorage
parseStringContentList i:19;Str:launchMode
parseStringContentList i:20;Str:configChanges
parseStringContentList i:21;Str:scheme
parseStringContentList i:22;Str:screenOrientation
parseStringContentList i:23;Str:windowSoftInputMode
parseStringContentList i:24;Str:exported
parseStringContentList i:25;Str:value
parseStringContentList i:26;Str:authorities
parseStringContentList i:27;Str:grantUriPermissions
parseStringContentList i:28;Str:resource
parseStringContentList i:29;Str:process
parseStringContentList i:30;Str:enabled
parseStringContentList i:31;Str:priority
parseStringContentList i:32;Str:excludeFromRecents
parseStringContentList i:33;Str:foregroundServiceType
parseStringContentList i:34;Str:initOrder
parseStringContentList i:35;Str:permission
parseStringContentList i:36;Str:taskAffinity
parseStringContentList i:37;Str:multiprocess
parseStringContentList i:38;Str:noHistory
parseStringContentList i:39;Str:targetActivity
parseStringContentList i:40;Str:manifest
parseStringContentList i:41;Str:package
parseStringContentList i:42;Str:com.aaxxsspp.app
parseStringContentList i:43;Str:platformBuildVersionCode
parseStringContentList i:44;Str:platformBuildVersionName
parseStringContentList i:45;Str:http://schemas.android.com/apk/res/android
parseStringContentList i:46;Str:2.3.2
parseStringContentList i:47;Str:10
parseStringContentList i:48;Str:uses-sdk
parseStringContentList i:49;Str:uses-feature
parseStringContentList i:50;Str:android.hardware.camera
parseStringContentList i:51;Str:android.hardware.camera.autofocus
parseStringContentList i:52;Str:uses-permission
parseStringContentList i:53;Str:android.permission.INTERNET
parseStringContentList i:54;Str:android.permission.WRITE_EXTERNAL_STORAGE
parseStringContentList i:55;Str:android.permission.READ_EXTERNAL_STORAGE
parseStringContentList i:56;Str:android.permission.ACCESS_NETWORK_STATE
parseStringContentList i:57;Str:android.permission.ACCESS_WIFI_STATE
parseStringContentList i:58;Str:android.permission.CHANGE_WIFI_STATE
parseStringContentList i:59;Str:com.tiger.app1.tiger.permission.JPUSH_MESSAGE
parseStringContentList i:60;Str:android.permission.RECEIVE_USER_PRESENT
parseStringContentList i:61;Str:android.permission.MOUNT_UNMOUNT_FILESYSTEMS
parseStringContentList i:62;Str:android.permission.WRITE_SETTINGS
parseStringContentList i:63;Str:android.permission.ACCESS_COARSE_LOCATION
parseStringContentList i:64;Str:android.permission.ACCESS_FINE_LOCATION
parseStringContentList i:65;Str:android.permission.SYSTEM_ALERT_WINDOW
parseStringContentList i:66;Str:android.permission.ACCESS_LOCATION_EXTRA_COMMANDS
parseStringContentList i:67;Str:android.permission.CHANGE_NETWORK_STATE
parseStringContentList i:68;Str:android.permission.GET_TASKS
parseStringContentList i:69;Str:android.permission.VIBRATE
parseStringContentList i:70;Str:android.permission.RECORD_AUDIO
parseStringContentList i:71;Str:android.permission.WAKE_LOCK
parseStringContentList i:72;Str:android.permission.CAMERA
parseStringContentList i:73;Str:android.permission.FOREGROUND_SERVICE
parseStringContentList i:74;Str:android.permission.READ_PHONE_STATE
parseStringContentList i:75;Str:android.permission.BLUETOOTH
parseStringContentList i:76;Str:android.permission.CHANGE_WIFI_MULTICAST_STATE
parseStringContentList i:77;Str:android.permission.REQUEST_INSTALL_PACKAGES
parseStringContentList i:78;Str:android.permission.READ_SETTINGS
parseStringContentList i:79;Str:android.permission.READ_LOGS
parseStringContentList i:80;Str:com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE
parseStringContentList i:81;Str:permission
parseStringContentList i:82;Str:com.aaxxsspp.app.permission.JPUSH_MESSAGE
parseStringContentList i:83;Str:android.permission.ACCESS_BACKGROUND_LOCATION
parseStringContentList i:84;Str:android.permission.PACKAGE_USAGE_STATS
parseStringContentList i:85;Str:application
parseStringContentList i:86;Str:com.stub.StubApp
parseStringContentList i:87;Str:google
parseStringContentList i:88;Str:activity
parseStringContentList i:89;Str:com.gulu.dlna.DlnaLelinkActivity
parseStringContentList i:90;Str:com.gulu.all.ui.activity.SplashActivity
parseStringContentList i:91;Str:com.gulu.all.ui.activity.SplashActivityNew
parseStringContentList i:92;Str:intent-filter
parseStringContentList i:93;Str:action
parseStringContentList i:94;Str:android.intent.action.MAIN
parseStringContentList i:95;Str:category
parseStringContentList i:96;Str:android.intent.category.LAUNCHER
parseStringContentList i:97;Str:android.intent.action.VIEW
parseStringContentList i:98;Str:android.intent.category.DEFAULT
parseStringContentList i:99;Str:android.intent.category.BROWSABLE
parseStringContentList i:100;Str:data
parseStringContentList i:101;Str:xlrhtt
parseStringContentList i:102;Str:xieydwqgh
parseStringContentList i:103;Str:com.gulu.all.MainActivity
parseStringContentList i:104;Str:com.gulu.all.ui.activity.FeedbackActivity
parseStringContentList i:105;Str:com.gulu.all.ui.activity.MyFeedbackRecordsActivity
parseStringContentList i:106;Str:com.gulu.all.ui.activity.MyCollectActivity
parseStringContentList i:107;Str:com.gulu.all.ui.activity.LookRecordActivity
parseStringContentList i:108;Str:com.gulu.all.ui.activity.MessageCenterActivity
parseStringContentList i:109;Str:com.gulu.all.ui.activity.TaskCenterActivity
parseStringContentList i:110;Str:com.gulu.all.ui.activity.PromoteCenterActivity
parseStringContentList i:111;Str:com.gulu.all.ui.activity.MyPromoteActivity
parseStringContentList i:112;Str:com.gulu.all.ui.activity.SettingActivity
parseStringContentList i:113;Str:com.gulu.all.ui.activity.LoginActivity
parseStringContentList i:114;Str:com.gulu.all.ui.activity.RegisterActivity
parseStringContentList i:115;Str:com.gulu.all.ui.activity.SearchVideoActivity
parseStringContentList i:116;Str:com.gulu.all.ui.activity.PushAtOnceAcitivity
parseStringContentList i:117;Str:com.gulu.all.ui.activity.AccountSafeActivity
parseStringContentList i:118;Str:com.gulu.all.ui.activity.WebViewActivity
parseStringContentList i:119;Str:com.gulu.all.ui.movie.activity.MovieDetailNewActivity
parseStringContentList i:120;Str:com.gulu.all.ui.activity.BindPhoneActivity
parseStringContentList i:121;Str:com.gulu.all.ui.activity.BindEmailActivity
parseStringContentList i:122;Str:com.gulu.all.ui.activity.ForgetPwdActivity
parseStringContentList i:123;Str:com.gulu.all.ui.activity.NewPwdActivity
parseStringContentList i:124;Str:com.gulu.all.ui.activity.VerifyCodeActivity
parseStringContentList i:125;Str:com.gulu.all.ui.activity.ClassifyActivity
parseStringContentList i:126;Str:com.gulu.all.ui.activity.MessageDetailActivity
parseStringContentList i:127;Str:com.gulu.all.ui.activity.AnnounceDetailActivity
parseStringContentList i:128;Str:com.gulu.all.ui.activity.ModifyPwdActivity
parseStringContentList i:129;Str:com.gulu.all.ui.activity.ModifyNameActivity
parseStringContentList i:130;Str:com.gulu.all.ui.movie.activity.DownloadActivity
parseStringContentList i:131;Str:com.gulu.all.ui.movie.activity.MovieDownloadActivity
parseStringContentList i:132;Str:com.gulu.all.ui.movie.activity.DownloadHistoryActivity
parseStringContentList i:133;Str:com.gulu.all.ui.activity.AgreementActivity
parseStringContentList i:134;Str:com.gulu.all.ui.activity.SelectAreaCodeActivity
parseStringContentList i:135;Str:com.gulu.all.ui.activity.WithdrawalActivity
parseStringContentList i:136;Str:com.gulu.all.ui.activity.MembersActivity
parseStringContentList i:137;Str:com.gulu.all.ui.activity.MembersRechargeActivity
parseStringContentList i:138;Str:com.gulu.all.ui.activity.WithdrawalAccountActivity
parseStringContentList i:139;Str:com.gulu.all.ui.activity.WithdrawListActivity
parseStringContentList i:140;Str:com.gulu.all.ui.activity.LookMoneyActivity
parseStringContentList i:141;Str:com.gulu.all.ui.activity.MyEarningsActivity
parseStringContentList i:142;Str:com.gulu.all.ui.activity.ChannelDetailActivity
parseStringContentList i:143;Str:com.gulu.all.ui.activity.BoxActivity
parseStringContentList i:144;Str:com.gulu.all.ui.activity.BoxTranslucentActivity
parseStringContentList i:145;Str:com.gulu.all.ui.activity.BoxShareActivity
parseStringContentList i:146;Str:com.gulu.all.ui.activity.RechargeHelperActivity
parseStringContentList i:147;Str:com.gulu.all.ui.activity.RechargeRecordActivity
parseStringContentList i:148;Str:com.gulu.all.ui.activity.KFOrderQueryActivity
parseStringContentList i:149;Str:com.gulu.all.ui.activity.RechargeFeedbackActivity
parseStringContentList i:150;Str:com.gulu.all.ui.activity.RechargeFeedbackDetailActivity
parseStringContentList i:151;Str:com.gulu.all.ui.activity.OrderSelectActivity
parseStringContentList i:152;Str:com.gulu.all.ui.activity.SetLockScreenPwdActivity
parseStringContentList i:153;Str:com.gulu.all.ui.activity.LockScreenPwdActivity
parseStringContentList i:154;Str:com.gulu.all.ui.movie.activity.SeriesVideoActivity
parseStringContentList i:155;Str:com.gulu.all.ui.activity.MyWalletActivity
parseStringContentList i:156;Str:com.gulu.all.ui.activity.PromotMethodActivity
parseStringContentList i:157;Str:com.gulu.all.ui.activity.MoreVideoActivity
parseStringContentList i:158;Str:com.gulu.all.ui.activity.FixedVideosActivity
parseStringContentList i:159;Str:com.gulu.all.ui.activity.HeadImgSelectActivity
parseStringContentList i:160;Str:com.gulu.all.ui.activity.GoldExchangeActivity
parseStringContentList i:161;Str:cn.jpush.android.ui.PopWinActivity
parseStringContentList i:162;Str:com.gulu.all.ui.activity.SpecialTopicDetailActivity
parseStringContentList i:163;Str:cn.jpush.android.ui.PushActivity
parseStringContentList i:164;Str:com.tiger.app1.tiger
parseStringContentList i:165;Str:meta-data
parseStringContentList i:166;Str:com.openinstall.APP_KEY
parseStringContentList i:167;Str:com.xinstall.APP_KEY
parseStringContentList i:168;Str:eydwqgh
parseStringContentList i:169;Str:UMENG_APPKEY
parseStringContentList i:170;Str:5cee36cc570df3df3d00116d
parseStringContentList i:171;Str:JPUSH_CHANNEL
parseStringContentList i:172;Str:developer-default
parseStringContentList i:173;Str:JPUSH_APPKEY
parseStringContentList i:174;Str:7c0e9fa75531ea6cbe0e4ef6
parseStringContentList i:175;Str:provider
parseStringContentList i:176;Str:com.gulu.all.base.MyBaseFileProvider
parseStringContentList i:177;Str:com.aaxxsspp.app.provider
parseStringContentList i:178;Str:android.support.FILE_PROVIDER_PATHS
parseStringContentList i:179;Str:cn.jpush.android.service.DataProvider
parseStringContentList i:180;Str::pushcore
parseStringContentList i:181;Str:com.aaxxsspp.app.DataProvider
parseStringContentList i:182;Str:cn.jpush.android.service.DownloadProvider
parseStringContentList i:183;Str:com.aaxxsspp.app.DownloadProvider
parseStringContentList i:184;Str:receiver
parseStringContentList i:185;Str:cn.jpush.android.service.PushReceiver
parseStringContentList i:186;Str:cn.jpush.android.intent.NOTIFICATION_RECEIVED_PROXY
parseStringContentList i:187;Str:android.intent.action.USER_PRESENT
parseStringContentList i:188;Str:android.net.conn.CONNECTIVITY_CHANGE
parseStringContentList i:189;Str:android.intent.action.PACKAGE_ADDED
parseStringContentList i:190;Str:android.intent.action.PACKAGE_REMOVED
parseStringContentList i:191;Str:com.gulu.all.receiver.MyReceiver
parseStringContentList i:192;Str:cn.jpush.android.intent.REGISTRATION
parseStringContentList i:193;Str:cn.jpush.android.intent.MESSAGE_RECEIVED
parseStringContentList i:194;Str:cn.jpush.android.intent.NOTIFICATION_RECEIVED
parseStringContentList i:195;Str:cn.jpush.android.intent.NOTIFICATION_OPENED
parseStringContentList i:196;Str:cn.jpush.android.intent.CONNECTION
parseStringContentList i:197;Str:cn.jpush.android.service.AlarmReceiver
parseStringContentList i:198;Str:service
parseStringContentList i:199;Str:cn.jpush.android.service.PushService
parseStringContentList i:200;Str:cn.jpush.android.intent.REGISTER
parseStringContentList i:201;Str:cn.jpush.android.intent.REPORT
parseStringContentList i:202;Str:cn.jpush.android.intent.PushService
parseStringContentList i:203;Str:cn.jpush.android.intent.PUSH_TIME
parseStringContentList i:204;Str:com.sh.sdk.shareinstall.service.PollingService
parseStringContentList i:205;Str:com.hpplay.sdk.source.process.LelinkSdkService
parseStringContentList i:206;Str::lelinkps
parseStringContentList i:207;Str:com.hpplay.sdk.source.LelinkSdkService.ACTION
parseStringContentList i:208;Str:com.hpplay.sdk.source.permission.PermissionBridgeActivity
parseStringContentList i:209;Str:com.hpplay.sdk.source.mirror.ScreenCastService
parseStringContentList i:210;Str:com.hpplay.sdk.source.mirrorcast.ScreenCastService.ACTION
parseStringContentList i:211;Str:com.fanle.adlibrary.sdk.core.activity.BBRewardVideoActivity
parseStringContentList i:212;Str:com.fanle.adlibrary.webview.AdWebViewActivity
parseStringContentList i:213;Str:com.google.android.gms.ads.APPLICATION_ID
parseStringContentList i:214;Str:ca-app-pub-5511418951767100~5306890786
parseStringContentList i:215;Str:com.jskj.advertising.ui.JiSuBrowserActivity
parseStringContentList i:216;Str:com.luck.picture.lib.PictureFileProvider
parseStringContentList i:217;Str:com.luck.picture.lib.PictureSelectorActivity
parseStringContentList i:218;Str:com.luck.picture.lib.PicturePreviewActivity
parseStringContentList i:219;Str:com.luck.picture.lib.PictureVideoPlayActivity
parseStringContentList i:220;Str:com.luck.picture.lib.PictureExternalPreviewActivity
parseStringContentList i:221;Str:com.yalantis.ucrop.UCropActivity
parseStringContentList i:222;Str:com.yalantis.ucrop.PictureMultiCuttingActivity
parseStringContentList i:223;Str:com.luck.picture.lib.PicturePlayAudioActivity
parseStringContentList i:224;Str:com.dlna.android.upnpcast.service.NLUpnpCastService
parseStringContentList i:225;Str:com.bumptech.glide.integration.okhttp3.OkHttpGlideModule
parseStringContentList i:226;Str:GlideModule
parseStringContentList i:227;Str:com.google.android.gms.ads.AdActivity
parseStringContentList i:228;Str:com.google.android.gms.ads.MobileAdsInitProvider
parseStringContentList i:229;Str:com.aaxxsspp.app.mobileadsinitprovider
parseStringContentList i:230;Str:com.google.android.gms.measurement.AppMeasurementReceiver
parseStringContentList i:231;Str:com.google.android.gms.measurement.AppMeasurementInstallReferrerReceiver
parseStringContentList i:232;Str:android.permission.INSTALL_PACKAGES
parseStringContentList i:233;Str:com.android.vending.INSTALL_REFERRER
parseStringContentList i:234;Str:com.google.android.gms.measurement.AppMeasurementService
parseStringContentList i:235;Str:com.google.android.gms.measurement.AppMeasurementJobService
parseStringContentList i:236;Str:android.permission.BIND_JOB_SERVICE
parseStringContentList i:237;Str:com.google.android.gms.version
parseStringContentList i:238;Str:com.liulishuo.filedownloader.services.FileDownloadService$SharedMainProcessService
parseStringContentList i:239;Str:com.liulishuo.filedownloader.services.FileDownloadService$SeparateProcessService
parseStringContentList i:240;Str::filedownloader
parseStringContentList i:241;Str:com.blankj.utilcode.util.PermissionUtils$PermissionActivity
parseStringContentList i:242;Str:cn.jpush.android.service.DaemonService
parseStringContentList i:243;Str:cn.jpush.android.intent.DaemonService
parseStringContentList i:244;Str:cn.jpush.android.service.JNotifyActivity
parseStringContentList i:245;Str:jpush.custom
parseStringContentList i:246;Str:cn.jpush.android.intent.JNotifyActivity
parseStringContentList i:247;Str:dexopt
parseStringContentList i:248;Str:com.tencent.smtt.export.external.DexClassLoaderProviderService
parseStringContentList i:249;Str::dexopt
parseStringContentList i:250;Str:com.jskj.advertising.service.AdvertisingService
parseStringContentList i:251;Str:com.jskj.advertising.service.DownloadFileService
parseStringContentList i:252;Str:com.jskj.advertising.sdk.JiSuFileProvider
parseStringContentList i:253;Str:com.aaxxsspp.app.tbsfileprovider
parseStringContentList i:254;Str:com.jskj.advertising.ui.JiSuAdvertisingReadActivity
parseStringContentList i:255;Str:com.mob.MobProvider
parseStringContentList i:256;Str:com.aaxxsspp.app.com.mob.MobProvider
parseStringContentList i:257;Str:Mob-AppKey
parseStringContentList i:258;Str:2bcc0c557ca50
parseStringContentList i:259;Str:Mob-AppSecret
parseStringContentList i:260;Str:5b46abda5f62174db2d8fb2c1f48cf37
parseStringContentList i:261;Str:com.mob.tools.MobUIShell
parseStringContentList i:262;Str:com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY
parseStringContentList i:263;Str:cn.sharesdk.framework.utils.ShareSDKFileProvider
parseStringContentList i:264;Str:com.aaxxsspp.app.cn.sharesdk.ShareSDKFileProvider
parseStringContentList i:265;Str:cn.sharesdk.tencent.qq.ReceiveActivity
parseStringContentList i:266;Str:tencent101854294
parseStringContentList i:267;Str:com.tencent.tauth.AuthActivity
parseStringContentList i:268;Str:com.tencent.connect.common.AssistActivity
parseStringContentList i:269;Str:com.mob.guard.MobGuardUpService
parseStringContentList i:270;Str:com.mob.intent.MOB_GUARD_SERVICE
parseStringContentList i:271;Str:com.mob.guard.MobGuardCommonIdBCReceiver
parseStringContentList i:272;Str:com.mlive.id
parseStringContentList i:273;Str:com.mob.MobTranUpActivity
parseStringContentList i:274;Str:com.mob.open.app
parseStringContentList i:275;Str:cn.sharesdk.wechat.utils.WechatHandlerActivity
parseStringContentList i:276;Str:activity-alias
parseStringContentList i:277;Str:com.aaxxsspp.app.wxapi.WXEntryActivity
parseStringContentList i:278;Str:android
```



### ResourceIDChunk

```
		  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f 
00004e90h:80 01 08 00 a8 00 00 00 1b 02 01 01 1c 02 01 01
```

ResourceIdChunk标识符(4个字节):0x00080180

ResourceChunkSize(4个字节)    :0x000000A8 (168个字节)。每个ResourceId值为4个字节，出去开头固定的8个字节。本AndroidManifest共有(168 - 8)/4=40个ResourceId。0x00004E98开始的4个字节内容为0x0101021B即为ResourceId值，根据public.xml内容，可知其对应值如下,但是在
分析 AXMLPrinter2 的源码过程中发现 ResourceId 的值貌似没有使用到,ResourceId 对应的
name 在 String Pool 中有直接对应的值。

<public type="attr" name="versionCode" id="0x0101021b" />

第二个0x010102C

.....

第40个0x01010202，在0x00004F34开始



## XML Content

接下来即为XML Content的内容，此部分一共有5种类型的Chunk，分别为

Start NameSapce Chunk(0x00100100),开始位置0x00004f38, 

End Namespace Chunk(0x00100101) ,开始位置, 

Start TagChunk(0x00100102),开始位置0x00004f50, 

End Tag Chunk(0x00100103)以及 

Text Chunk(0x00100104)。这 5 种 Chunk的**开头 4 个属性(16 bytes)的含义都是一样的,分别表示 Chunk 类型标识、 Chunk Size,行号(对应编码前原文件内容的行号)、固定值 0xFFFFFFFF**。



###  Start Namespace Chunk(0x00100100)

ResourceId Chunk 结束后,首先是 Start Namespace Chunk,类型标识为 0x00100100(在0x00004F38开始);大小为 0x00000018,即 24 bytes;行号为(0xFFFFFFFF) -1,空白4个字符(0xFFFFFFFF);

Prefix值为0x00000116(278);其表示 String Pool 中的字符串索引值,索引278的值为"android"。

Uri 值为 0x0000002D(45),其同样为 String Pool中的字符串索引值,索引45的值为"http://schemas.android.com/apk/res/android"。Prefix 与 Uri 在此处是对应关系,**后续的 Start Chunk Type 中的 Attribute 会根据 Uri 来获得 Prefix 值**。



### Start Tag Chunk (0x00100102)

Start Tag Chunk 的标识为 0x00100102(起始位置0x00004F50); 0x000000B0 为 Chunk Size,即 176 bytes,因此其区间为 0x00004F50-0x00005000;0x00003F58处为行号(0x0000001);0x00004F60h处的 4 字节内容为 0xFFFFFFFF 为命名空间的Uri,即为-1,根据 AXMLPrinter2 的源码当为-1 时,返回值为 null,命名空间为空;接下来的4 个字节内容为该 Tag 的名称的字符串索引值 0x00000028,索引为40,因此值为 manifest;

0x00004f6c开始处的 4 个字节内容为 XML 标签下的属性个数,此处值为 0x00000007,即一共 7 个属性,

每个属性由5*4bytes构成,实际上是一个长度为5的数组。数组的每个含义为[Namespace
Uri, Name, Value String, Type, Data].

第１个属性开始0x00004f74h:

[0xFFFFFFFF,  0x00000029, 0x0000002A, 0x03000008, 0x0000002A],而数组第 4 个值在实际处理过程中会首先右移 24 位(0x03000008>>>24),因此数组值实际为[-1, 41, 42, 3, 42],第1个值为命名空间的Uri,

根据 AXMLPrinter2 的源码当为-1 时,返回值为 null,命名空间为空;第2个为属性名称的字符串索引，41对应的字符串，因此值为:package；第3个值是在当Type为表示字符串时与Data值相同；第4个值表示数据的类型,包括 String、Attribute、Reference、Float、Int Hex、Int Boolean、Int 等(具体可以参考 AXMLPrinter2 的源码test/AXMLPrinter 类中的 getAttributeValue 函数),由于此处 Type 值为 3,表示是个String;第5个值即为属性的内容，由于Type只是为字符串，因此属性内容为索引为42处的值，值为com.aaxxsspp.app

[null,package,com.aaxxsspp.app,String,com.aaxxsspp.app]。综上第一个属性解码后应该为package="com.aaxxsspp.app"。



第２个属性开始为0x00004f88

[0xFFFFFFFF, 0x0000002B, 0xFFFFFFFF, 0x10000008, 0x0000001D].

数组值实际为[-1,43,-1,16,29],第1个值为命名空间的Uri,-1时，返回值为null;第２个为属性名称的字符串索引,索引43对应的字符串为platformBuildVersionCode；第４个值为16，表示是个int；第５个值29;

综上第２个属性解码后为: 

platformBuildVersionCode="29";



第３个属性开始为0x00004f9c;

[0xFFFFFFFF, 0x0000002C, 0xFFFFFFFF, 0x10000008, 0x0000000A]

数组值实际为[-1,44,-1,16,10]

综上第3个属性解码后为:

 platformBuildVersionName="10";



第４个属性开始为0x00004fb0

[0x0000002D, 0x00000000, 0xFFFFFFFF, 0x10000008, 0x00002793]

数组值实际为[45,0,-1,16,10],第1个值为命名空间的Uri,索引为45时，其同样为 String Pool中的字符串索引值,索引45的值为"http://schemas.android.com/apk/res/android"。

Prefix值为0x00000116(278);其表示 String Pool 中的字符串索引值,索引278的值为"android"。

Uri 值为 0x0000002D(45)。Prefix 与 Uri 在此处是对应关系,**后续的 Start Chunk Type 中的 Attribute 会根据 Uri 来获得 Prefix 值**。

综上第4个属性解码后为:

android:versionCode="10"



第５个属性开始为0x00004fc4

[0x0000002D, 0x00000001, 0x0000002E, 0x03000008, 0x0000002E]

数组值实际为[45,1,46,3,46]

综上第5个属性解码后为:

android:versionName="2.3.2"



第6个属性开始为0x00004fd8

[0x0000002D, 0x00000002, 0xFFFFFFFF, 0x10000008, 0x0000001D]

数组值实际为[45,2,-1,16,29]

android:compileSdkVersion="29"



第7个属性开始为0x00004fec

[0x0000002D, 0x00000003, 0x0000002F, 0x03000008, 0x0000002F]

数组值实际为[45,3,47,3,47]

android:compileSdkVersionCodename="10"



### Start Tag Chunk(0x00100102)(起始位置0x00005000)

Start Tag Chunk 的标识为 0x00100102(起始位置0x00005000); 0x0000004C 为 Chunk Size,即 76 bytes,因此其区间为 (0x00005000-0x000054b;0x00005008处行号为0x00000002；0x00005010处的 4 字节内容为 0xFFFFFFFF 为命名空间的Uri,即为-1,根据 AXMLPrinter2 的源码当为-1 时,返回值为 null,命名空间为空;接下来的4 个字节内容为该 Tag 的名称的字符串索引值 0x00000030,索引为48,因此值为 uses-sdk;0x0000501c处为属性个数0x00000002;

每个属性由5*4bytes构成,实际上是一个长度为5的数组。数组的每个含义为

[Namespace Uri, Name, Value String, Type, Data].



第１个属性开始0x00005f24h:

[0x0000002D, 0x00000004, 0xFFFFFFFF, 0x10000008, 0x00000013]

数组值实际为[45,4,-1,16,19]

android:minSdkVersion="19"



第2个属性开始0x00005f38h:

[0x0000002D, 0x00000005, 0xFFFFFFFF, 0x10000008, 0x0000001D]

数组值实际为[45,5,-1,16,29]

android:targetSdkVersion="29"



### End Tag Chunk(0x00100103)(起始位置0x0000504c)

End Tag Chunk 的标识为 0x00100103(起始位置0x0000504c); 接下来的4 个字节内容为该 Tag的长度大小

 0x00000018(24个字节)(结束位置0x00005064);

Tag 的名称的字符串索引值 0x00000030,索引为48,因此值为 uses-sdk;





### Start Tag Chunk(0x00100102)(起始位置0x00005064)

Start Tag Chunk 的标识为 0x00100102(起始位置0x00005064);

size为0x38(56)(0x00005064-0x0000509c)

行号为0x3;

0x00005074处的 4 字节内容为 0xFFFFFFFF 为命名空间的Uri,即为-1,根据 AXMLPrinter2 的源码当为-1 时,返回值为 null,命名空间为空;接下来的4 个字节内容为该 Tag 的名称的字符串索引值 0x00000031,索引为49,因此值为 uses-feature;0x00005080处为属性个数0x00000001;

每个属性由5*4bytes构成,实际上是一个长度为5的数组。数组的每个含义为

[Namespace Uri, Name, Value String, Type, Data].



第１个属性开始0x00005f24h:

[0x0000002D, 0x00000006, 0x00000032, 0x03000008, 0x00000032]

数组值实际为[45,6,50,3,50]

android:name="android.hardware.camera"



### End Tag Chunk(0x00100103)(起始位置0x0000509c)

End Tag Chunk 的标识为 0x00100103(起始位置0x0000509c); 接下来的4 个字节内容为该 Tag的长度大小

 0x00000018(24个字节)(结束位置0x000050a0);

Tag 的名称的字符串索引值 0x00000031,索引为49,因此值为uses-feature









End Namespace Chunk(0x00100101) ,开始位置, 

End Tag Chunk(0x00100103)以及 

Text Chunk(0x00100104)















