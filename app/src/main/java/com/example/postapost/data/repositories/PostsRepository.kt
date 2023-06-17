package com.example.postapost.data.repositories

import android.content.Context
import com.example.postapost.data.models.Post

class PostsRepository(val context: Context) {


    fun getFakePosts(): ArrayList<Post> {
        val post1 = Post(
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            id = 1,
            reactions = 10,
            tags = listOf("tag1", "tag2", "tag3"),
            title = "Post 1",
            userId = 100
        )

        val post2 = Post(
            body = "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            id = 2,
            reactions = 5,
            tags = listOf("tag2", "tag3", "tag4"),
            title = "Post 2",
            userId = 200
        )

        val post3 = Post(
            body = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.",
            id = 3,
            reactions = 15,
            tags = listOf("tag3", "tag4", "tag5"),
            title = "Post 3",
            userId = 300
        )

        val post4 = Post(
            body = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
            id = 4,
            reactions = 8,
            tags = listOf("tag4", "tag5", "tag6"),
            title = "Post 4",
            userId = 400
        )

        val post5 = Post(
            body = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            id = 5,
            reactions = 20,
            tags = listOf("tag5", "tag6", "tag7"),
            title = "Post 5",
            userId = 500
        )

        val post6 = Post(
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            id = 6,
            reactions = 12,
            tags = listOf("tag6", "tag7", "tag8"),
            title = "Post 6",
            userId = 600
        )

        val post7 = Post(
            body = "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            id = 7,
            reactions = 3,
            tags = listOf("tag7", "tag8", "tag9"),
            title = "Post 7",
            userId = 700
        )

        val post8 = Post(
            body = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.",
            id = 8,
            reactions = 18,
            tags = listOf("tag8", "tag9", "tag10"),
            title = "Post 8",
            userId = 800
        )

        val postList = ArrayList<Post>()
        postList.add(post1)
        postList.add(post2)
        postList.add(post3)
        postList.add(post4)
        postList.add(post5)
        postList.add(post6)
        postList.add(post7)
        postList.add(post8)

        return postList
    }


}