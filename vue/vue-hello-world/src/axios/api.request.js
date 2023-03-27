

import axios from 'axios'
export function request(config) {
    // 1. 创建axios实例
    const instance = axios.create({
        baseURL: 'http://localhost:8010/api/',
        timeout: 5000
    })
    // 2. axios的请求拦截器
    // 2.1 请求拦截
    instance.interceptors.request.use(config => {
        config.headers.Authorization = localStorage.getItem('token')
        return config
    }, error => {
        // console.log(error);
    })
    // 2.2 响应拦截
    instance.interceptors.response.use(res => {
        return res.data
    }, err => {
        console.log(err);
    })

    // 3. 发送真正的网络请求
    return instance(config)

}


// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
// axios.defaults.withCredentials = true;
// export function request(config) {

//     // 1. 创建axios实例
//     const instance = axios.create({
//         baseURL: 'http://localhost:8010/api/',
//         // baseURL: 'http://192.168.31.162:8010/api/',
//         timeout: 5000
//     })
//     // 2. axios的请求拦截器
//     // 2.1 请求拦截
//     instance.interceptors.request.use(config => {
//          //Ajax请求执行该方法，请求带上token
//         // 将所有的网络请求头都带上本地存储的 Token
//         request.interceptors.request.use(config => {
//             const token = localStorage.getItem('authorization')
//             token && (config.headers.authorization = token)
//             return config
//         })
//     }, error => {
//          // loadingInstance.close()
//     Message.error({
//         message: '加载超时'
//     });
//     return Promise.reject(error);
//         // console.log(error);
//     })
//     // 2.2 响应拦截
//     instance.interceptors.response.use(res => {
//         const token = response.headers.authorization
//         if (token) {
//           localStorage.setItem('authorization', token)
//         } else {
//           localStorage.removeItem('authorization')
//           router.push('/login')
//         }
//         return res.data
//     }, err => {
//         if (error.response.status === 401) {
//             if (count === 0) {
//                 count = count + 1;
//             } else if (count > 0) {
//                 return null;
//             }
//             // debugger
//             Message.error("身份信息超时，请重新登录！", { icon: 1, time: 2000 });
//             $cookies.remove('userToken');
//             setTimeout(function () {
//                 window.location.href = '/#/login';
//             }, 3000);
//             return Promise.reject(error);
//         }
//         console.log(err);
//     })

//     // 3. 发送真正的网络请求
//     return instance(config)
// }