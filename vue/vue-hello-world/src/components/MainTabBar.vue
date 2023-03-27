<template>
  <div>
    <tab-bar>
      <tab-bar-item path="/home" activeColor="purple">
        <img slot="item-icon" src="../assets/img/tabbar/shouye.png" alt="" />
        <img
          slot="item-icon-active"
          src="../assets/img/tabbar/shouye.cative.png"
          alt=""
        />
        <div slot="item-text">首页</div>
      </tab-bar-item>
      <tab-bar-item path="/profile" activeColor="purple">
        <img slot="item-icon" src="../assets/img/tabbar/wode.png" alt="" />
        <img
          slot="item-icon-active"
          src="../assets/img/tabbar/wode.active.png"
          alt=""
        />
        <div slot="item-text">我的</div>
      </tab-bar-item>
    </tab-bar>
  </div>
</template>
 
<script>
import TabBar from "./tabbar/TabBar.vue";
import TabBarItem from "./tabbar/TabBarItem.vue";

export default {
  name: "MainTabBar",
  components: {
    TabBar,
    TabBarItem,
  },
};
</script>
 
<style>
</style>
 