<template>
  <div id="sing-up">
    <el-radio-group v-model="labelPosition" size="small">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm">
        <el-form-item label="姓名" prop="userName">
          <el-input v-model="ruleForm.userName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input v-model="ruleForm.idCard" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="tel">
          <el-input v-model.number="ruleForm.tel"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="regist()">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-radio-group>
    <el-button plain @click="open" v-show="false"> </el-button>
  </div>
</template>
      
  <script>
import { addUser } from "../../api/regist.js";
export default {
  name: "Regist",
  data() {
    var checkUserName = (rule, value, callback) => {
      var reg = /\d/;
      if (value == +" ") {
        callback(new Error("请输入姓名"));
      } else {
        if (reg.test(value)) {
          return callback(new Error("姓名输入有误"));
        }
        setTimeout(() => {
          if (value.length < 2) {
            callback(new Error("姓名输入有误"));
          } else {
            callback();
          }
        }, 1000);
      }
    };
    var checkIdCard = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入身份证号"));
      } else {
        if (value.length != 18) {
          callback(new Error("身份证输入有误"));
        }
        callback();
      }
    };
    var checkTel = (rule, value, callback) => {
      var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
      if (value === "") {
        callback(new Error("请再次输入手机号"));
      } else if (myreg.test(value)) {
        callback(new Error("手机号输入有误"));
      } else {
        callback();
      }
    };
    return {
      addUserResult: "",
      ruleForm: {
        userName: "",
        idCard: "",
        tel: "",
      },
      labelPosition: "top",
      rules: {
        // userName: [{ validator: checkUserName, trigger: "blur" }],
        // idCard: [{ validator: checkIdCard, trigger: "blur" }],
        // tel: [{ validator: checkTel, trigger: "blur" }],
      },
    };
  },
  methods: {
    regist() {
      addUser(this.ruleForm).then((response) => {
        if (response.code == 200) {
          this.$message({
            message: response.message,
            type: "success",
          });
          this.$router.push({ name: "login" });
          this.ruleForm = {
            userName: "",
            idCard: "",
            tel: "",
          };
        }
      });
    },

    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        console.log(this.ruleForm);
        addUserAction(this.ruleForm).then((response) => {});
      });
    },
    open(data) {
      if (data != 0) {
        this.$notify.success({
          title: "Info",
          message: "注册成功",
          showClose: false,
          position: "top-left",
          duration: 5,
        });
      } else {
        this.$notify.error({
          title: "Info",
          message: "注册失败",
          showClose: false,
          position: "top-left",
          duration: 5,
        });
      }
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>
      
    <style >
</style>