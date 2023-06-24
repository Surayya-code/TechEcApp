package com.example.techecapp.service

import com.example.techecapp.util.Constants.BASE_URL


class ApiUtils {
    companion object{
        fun getApi(): Service{
            return RetrofitUtils.getRetrofit(BASE_URL ).create(Service::class.java)
        }
    }
}