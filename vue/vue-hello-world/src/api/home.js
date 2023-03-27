import {
    request
  } from "../axios/api.request"

  export function updateHealthCodeByIdCard(parameter) {
    return request({
      url: '/updateHealthCode',
      method: 'get',
      params: {
        idCard: parameter
      }
    })
  }
  

  