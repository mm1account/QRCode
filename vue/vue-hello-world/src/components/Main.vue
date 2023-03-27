<template>
  <div>
    <template>
      <component :is="view" ref="home"></component>
    </template>

    <main-tab-bar></main-tab-bar>
  </div>
</template>

<script>
import MainTabBar from "./MainTabBar.vue";
import Home from "../views/home/home.vue";
import Profile from "../views/porfile/profile.vue";
export default {
  name: "Main",
  components: {
    MainTabBar,
    Home,
    Profile,
  },
  watch: {
    $route(to, from) {
      console.log(from.path); //从哪来
      if (to.path == "/profile") {
        this.view = "Profile";
      } else if (to.path == "/home") {
        this.view = "Home";
      } else {
        this.view = " ";
      }
    },
  },

  data() {
    return {
      view: "Home",
    };
  },

  mounted() {},
  created() {
    console.log(this.$route.path);
  },
  methods: {},
};
</script>

<style lang="scss" scoped>
</style>