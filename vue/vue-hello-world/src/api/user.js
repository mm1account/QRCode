// import HttpRequest from '@/axios/api.request'

import {
  request
} from "../axios/api.request"

// export const UserQryAction = () => {
//   return HttpRequest.request({
//     url: 'user/',
//     method: 'get'
//   })
// }

  


// export const UserAddAction = (parameter) => {
//   return HttpRequest.request({
//     url: 'user/', 
//     method: 'post',
//     params: parameter
//   })
// }

export function UserAddAction(parameter) {
  return request({
    url: '/addUser',
    method: 'post',
    data: parameter
  })
}

// export const UserUpdateAction = (parameter) => {
//   return HttpRequest.request({
//     url: 'user/',
//     method: 'put',
//     params: parameter
//   })
// }

export function UserUpdateAction(parameter) {
  return request({
    url: '/user',
    method: 'put',
    params: parameter
  })
}

// export const UserDelAction = (parameter) => {
//   return HttpRequest.request({
//     url: 'user/',
//     method: 'delete',
//     params: {
//       no: parameter
//     }
//   })
// }

export function UserDelAction(parameter) {
  return request({
    url: 'user/',
    method: 'delete',
    params: {
      no: parameter
    }
  })
}


export function UserQryAction() {
  return request({
    url: '/user',
    method: 'get'
  })
}



// export const addUser = (user) => {

//   return HttpRequest.request({
//     url: 'addUser/',
//     method: 'post',
//     params: {
//       user: user
//     }
//   })

// }