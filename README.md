# BottomTableLayout

#### 介绍
区别于Android自带的TabLayout，区别是支持添加网络url按钮图标。

#### 安装教程

项目的root Gradle下添加 maven { url 'https://jitpack.io' }，如下

```markdown
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }

    allprojects {
        repositories {
            google()
            jcenter()
            maven { url 'https://jitpack.io' }
        }
    }
```
modle 的Gradle添加

```markdown
implementation 'com.github.daixuenan:bottomtablelayout:v1.0.0'
```

#### 使用说明

用法与TableLayout基本一致。

activity_main.xml
```markdown
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <!--添加一个ViewPager方便看效果-->
        <android.support.v4.view.ViewPager
            android:id="@+id/viewPager"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1" />

        <!--分割线 好看-->
        <View
            android:layout_width="match_parent"
            android:layout_height="0.5dp"
            android:background="#AAAAAA" />

        <!--TableLayout-->
        <com.dai.plugin.bottomtablelayout.BottomTabLayout
            android:id="@+id/tabLayout"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            android:background="#FFFFFF"
            android:elevation="10dp"
            app:tabBackground="@android:color/transparent"
            app:tabGravity="fill"
            app:tabIndicatorHeight="0dp"
            app:tabMode="fixed"
            app:tabSelectedTextColor="#FF6C3B" />
    </LinearLayout>
</RelativeLayout>
```

MainActivity.java
```markdown
public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    BottomTabLayout tabLayout;

    private PageFragmentAdapter pageFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        //初始化ViewPager和TableLayout
        List<Fragment> pageList = new ArrayList<>();
        pageList.add(new HomeFragment());
        pageList.add(new MeFragment());
        pageFragmentAdapter = new PageFragmentAdapter(getSupportFragmentManager(), pageList);
        viewPager.setOffscreenPageLimit(pageList.size());
        viewPager.setAdapter(pageFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //添加数据
        List<TabItem> tabItems = new ArrayList<>();
        TabItem tabItem1 = new TabItem(this);
        tabItem1.mText = "首页";
        tabItem1.mUnSelectedIconUrl = "http://img1.imgtn.bdimg.com/it/u=3392580235,766145748&fm=26&gp=0.jpg";
        tabItem1.mSelectedIconUrl = "http://img4.imgtn.bdimg.com/it/u=2267727531,3230746931&fm=26&gp=0.jpg";
        tabItems.add(tabItem1);

        TabItem tabItem2 = new TabItem(this);
        tabItem2.mText = "我的";
        tabItem2.mUnSelectedIconUrl = "http://img4.imgtn.bdimg.com/it/u=2030296515,204221599&fm=26&gp=0.jpg";
        tabItem2.mSelectedIconUrl = "http://img5.imgtn.bdimg.com/it/u=359150190,2955201467&fm=26&gp=0.jpg";
        tabItems.add(tabItem2);

        //绑定数据 注意tabItems数量与Fragment保持一致
        tabLayout.setData(tabItems);
    }
}
```

关键在这里
```markdown
         //添加数据（图标是网上随便搜的，不行的话可以随便再找几个试试）
         List<TabItem> tabItems = new ArrayList<>();
         TabItem tabItem1 = new TabItem(this);
         tabItem1.mText = "首页";
         tabItem1.mUnSelectedIconUrl = "http://img1.imgtn.bdimg.com/it/u=3392580235,766145748&fm=26&gp=0.jpg";
         tabItem1.mSelectedIconUrl = "http://img4.imgtn.bdimg.com/it/u=2267727531,3230746931&fm=26&gp=0.jpg";
         tabItems.add(tabItem1);
 
         TabItem tabItem2 = new TabItem(this);
         tabItem2.mText = "我的";
         tabItem2.mUnSelectedIconUrl = "http://img4.imgtn.bdimg.com/it/u=2030296515,204221599&fm=26&gp=0.jpg";
         tabItem2.mSelectedIconUrl = "http://img5.imgtn.bdimg.com/it/u=359150190,2955201467&fm=26&gp=0.jpg";
         tabItems.add(tabItem2);
 
         //绑定数据 注意tabItems数量与Fragment保持一致
         tabLayout.setData(tabItems);
```

Fragment继承Fragment即可，注意是android.support.v4.app.Fragment包下的。

补充PageFragmentAdapter.java 网上都有
```markdown
public class PageFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public PageFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void refresh(List<Fragment> fragmentList) {
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        this.fragmentList = fragmentList;
        notifyDataSetChanged();
    }

    public boolean onBackPressed() {
        boolean isBack = true;
        return isBack;
    }
}
```

跑一下就可以了。