import {
    request
  } from "../axios/api.request"

  export function loginAction(parameter) {
    return request({
      url: '/login',
      method: 'post',
      data: parameter
    })
  }
  