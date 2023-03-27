import {
    request
} from "../axios/api.request"


export function addUser(parameter) {
    return request({
        url: '/addUser',
        method: 'post',
        data: parameter
      })
  }
  