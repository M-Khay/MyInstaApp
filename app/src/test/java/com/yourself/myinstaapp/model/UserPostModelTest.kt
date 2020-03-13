package com.yourself.myinstaapp.model

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class DictionaryModelTest {
    private val likes = 200
    private val user = "Morris"

    @Mock
    var userPost: UserPost? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(userPost?.likes).thenReturn(likes)
        Mockito.`when`(userPost?.user).thenReturn(user)
    }

    @Test
    fun testUser() {
        Mockito.`when`(userPost?.user).thenReturn(user)
        Assert.assertEquals("Morris", userPost?.user)
    }

    @Test
    fun testLikes() {
        Mockito.`when`(userPost?.likes).thenReturn(likes)
        Assert.assertEquals(200, userPost?.likes)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        userPost = null
    }
}