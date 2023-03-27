<template>
  <div id="qr-code">
    <span ref="qrCodeUrl"></span>
  </div>
</template>

<script>
import QRCode from "qrcodejs2";
export default {
  name: "QRCode",
  data() {
    return {};
  },
  created() {
    // this.createQRCode(this.idCard, this.healthCode);
  },
  methods: {
    createQRCode(text, codeColor) {
      var codeColor = this.getQRCodeColor(codeColor);

      console.log(codeColor);
      this.$nextTick(() => {
        let qrcode = new QRCode(this.$refs.qrCodeUrl, {
          text: text, // 需要转换为二维码的内容
          width: 200,
          height: 200,
          colorDark: codeColor, //二维码颜色
          colorLight: "white", //二维码背景色
        });
      });
      console.log("二维码");
    },
    getQRCodeColor(code) {
      if (code == "1") {
        return "red";
      } else if (code == "2") {
        return "yellow";
      } else {
        return "green";
      }
    },
  },
};
</script>
