技术栈
前端 1.健康码系统 2.后台可视化系统
使用 Vue + element ui + echarts
通过对 axios 封装，实现请求的统一封装和对页面权限的验证

    后台
        框架：SpringBoot
        数据库：Mysql
        同时对接口返回数据封装实现了统一的数据结构 {code: "",message: "",data: {} }
        集成jwt验证用户身份

    设计思路：
        用户通过输入http://localhost:8000进入健康码系统，提供登录和注册功能；
            如果未注册，首先注册，然后跳转到登录页面。注册后用户的健康码并未激活，登进系统后点击领码激活健康码，健康码在客户端生成。
            如果已有账号，那么登入系统会进行判断，如果没有领取健康码，操作同上，如果领取就直接在前端生成健康码
        用户通过输入http://localhost:8001进入可视化系统，然后就是各地的领取健康码人数柱状图

    mysql：
        user:   id 主键自增
                userName: 用户名
                idCard：身份证号
                tel: 电话
        healthQRCodeUsed： idCard: 身份证号
                           status: 健康码状态 0:未领取  1:红 2:黄 3:绿

        adminUser:  userName: 用户名
                    pwd：密码
                    path: 权限路径 //暂未使用

        statisticsUser: city: 城市名称
                        num: 领取健康码的人数
