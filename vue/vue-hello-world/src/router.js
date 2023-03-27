import Vue from 'vue'
import VueRouter from 'vue-router';
const Home = () => import('./views/home/home.vue')
const Profile = () => import('./views/porfile/profile.vue')
const Login = () => import('./views/login/login.vue')
const Regist = () => import('./views/regist/regist.vue')
const Main = () => import('./components/Main.vue')

//1.安装插件
Vue.use(VueRouter)

//2.创建路由对象
const routes = [
    {
        path: '/',
        name: 'login',
        component: Login
    },
    {
        path:'/login',
        name: 'login',
        component: Login
    },
    {
        path:'/regist',
        name: 'regist',
        component: Regist
    },
    {
        path:'/main',
        name: 'main',
        component: Main,
        children: [
            { 
                path: '/home', 
                component: Home, 
                name: 'home' 
            },
            { 
                path: '/profile', 
                component: Profile, 
                name: 'profile' 
            },
        ]
    },
 
]
const router  = new VueRouter({
    routes,
    mode:'history'
})


// 设置全局的前置导航守卫
router.beforeEach((to, from, next) => {
    // 如果跳转的目的路径是 login 界面, 不做操作
    if (to.path === '/login' || to.path == "/regist") {
      next()
    } else {
      /**
       * 如果是其他界面, 判断本地是否存在 Token
       * 如果存在, 则正常跳转
       * 否则重定向到 login 界面
       */
      let token = localStorage.getItem('token')
      if (!token) {
        next('/login')
      } else {
        next()
      }
    }
  })

//3.导出router
export default router
