//package com.codingblocks.conduit.data
//
//import com.example.vishesh.realwolrdapp.data.ConduitClient
//import org.junit.Test
//import org.junit.Assert.*
//
//class ConduitClientTests {
//    @Test
//    fun `List all Articles is working`() {
//        val response = ConduitClient.conduitApi.getArticles().execute()
//        response.body()!!.let {
//            assertNotNull(it)
//            assertNotNull(it.article)
//            assertEquals(500, it.articleCount)
//        }
//    }
//}