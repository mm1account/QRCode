<template>
  <div>
    <el-form>
      <el-form-item label="身份证号">
        <el-input v-model="userInfo.idCard"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="userInfo.userName"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login()">登录</el-button>
        <el-button type="primary" @click="regist()">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { loginAction } from "../../api/login";

export default {
  name: "Login",
  components: {},
  data() {
    return {
      labelPosition: "right",
      userInfo: {
        userName: "",
        idCard: "",
      },
    };
  },

  mounted() {},

  methods: {
    //登录
    login() {
      console.log("123");
      loginAction(this.userInfo)
        .then((response) => {
          if (response.code == 200) {
            this.$store.commit("$_setToken", response.data.token);
            this.$message({
              message: response.message,
              type: "success",
            });
            localStorage.setItem("idCard", this.userInfo.idCard);
            localStorage.setItem("status", response.data.status);
            this.$router.push({
              path: "/home",
              // params: {
              //   isShowed: response.data.isShowed,
              //   idCard: this.userInfo.idCard,
              //   healthCode: response.data.healthCode,
              // },
            });
            this.userInfo = {};
          } else {
            this.$message.error(response.message);
          }
        })
        .catch((err) => {});
      // this.$router.push({ path: "/home" });
    },
    regist() {
      console.log("regist");
      this.$router.push({ path: "/regist" });
    },
  },
};
</script>

<style>
</style>