package com.example.retrofittest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//GET http://example.com/<page>/get_data.json
interface ExampleService {
    @GET("{page}/get_data.json")
    fun getData(@Path("page") page: Int): Call<Data>
}

//GET http://example.com/get_data.json?u=<user>&t=<token>
//interface ExampleService {
//    @GET("get_data.json")
//    fun getData(@Query("u") user: String, @Query("t") token: String): Call<Data>
//}

//DELETE http://example.com/data/<id>
//interface ExampleService {
//    @DELETE("data/{id}")
//    fun deleteData(@Path("id") id: String): Call<ResponseBody>
//}

//POST http://example.com/data/create
//{"id": 1, "content": "The description for this data."}
//interface ExampleService {
//    @POST("data/create")
//    fun createData(@Body data: Data): Call<ResponseBody>
//}

//GET http://example.com/get_data.json
//User-Agent: okhttp
//Cache-Control: max-age=0
//interface ExampleService {
//    @Headers("User-Agent: okhttp", "Cache-Control: max-age=0")
//    @GET("get_data.json")
//    fun getData(): Call<Data>
//}

//interface ExampleService {
//    @GET("get_data.json")
//    fun getData(@Header("User-Agent") userAgent: String,
//}