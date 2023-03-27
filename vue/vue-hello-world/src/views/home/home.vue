
<template>
  <div>
    <el-button type="primary" @click="getQRCode()" v-show="status == 0"
      >领码</el-button
    >
    <div div="qr" style="width: 200; height: 200" id="qr">
      <h2>健康码</h2>
      <q-r-code v-show="status != 1" ref="child"></q-r-code>
    </div>
  </div>
</template>

<script>
import QRCode from "../../components/QRCode.vue";
import { updateHealthCodeByIdCard } from "../../api/home.js";
export default {
  name: "Home",
  components: {
    QRCode,
  },
  created() {
    if (localStorage.getItem("status") != 0) {
      this.$nextTick(() => {
        this.$refs.child.createQRCode(
          localStorage.getItem("idCard"),
          localStorage.getItem("status")
        );
      });
    }
  },

  data() {
    return {
      status: localStorage.getItem("status"),
      idCard: "",
      healthCode: "",
    };
  },

  methods: {
    //点击领取健康码
    getQRCode() {
      localStorage.setItem("status", "3");
      updateHealthCodeByIdCard(localStorage.getItem("idCard")).then(
        (response) => {
          if (response.code == 200) {
            this.status = "3";
            this.$nextTick(() => {
              this.$refs.child.createQRCode(
                localStorage.getItem("idCard"),
                localStorage.getItem("status")
              );
            });
            this.$message({
              message: "领取成功",
              type: "success",
            });
          }
        }
      );
    },
  },
};
</script>

<style>
#qr {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
