package com.example.test5.model

import com.example.test5.R

data class Model(
    val content: List<ListItems>
)

data class ListItems(
    val fieldId: Int,
    val hint: String,
    val fieldType: String,
    val keyboard: String?,
    val required: Boolean,
    val isActive: Boolean,
    val icon: Int
)


val json = "[ \n" +
        "[ \n" +
        "{ \n" +
        "\"field_id\":1, \n" +
        "\"hint\":\"UserName\", \n" +
        "\"field_type\":\"input\", \n" +
        "\"keyboard\":\"text\", \n" +
        "\"required\":false, \n" +
        "\"is_active\":true, \n" +
        "\"icon\":\"https://jemala.png\" \n" +
        "}, \n" +
        "{ \n" +
        "\"field_id\":2, \n" +
        "\"hint\":\"Email\", \n" +
        "\"field_type\":\"input\", \n" +
        "\"required\":true, \n" +
        "\"keyboard\":\"text\", \n" +
        "\"is_active\":true, \n" +
        "\"icon\":\"https://jemala.png\" \n" +
        "}, \n" +
        "{ \n" +
        "\"field_id\":3, \n" +
        "\"hint\":\"phone\", \n" +
        "\"field_type\":\"input\", \n" +
        "\"required\":true, \n" +
        "\"keyboard\":\"number\", \n" +
        "\"is_active\":true, \n" +
        "\"icon\":\"https://jemala.png\" \n" +
        "} \n" +
        "], \n" +
        "[ \n" +
        "{ \n" +
        "\"field_id\":4,\n" +
        "\"hint\":\"FullName\", \n" +
        "\"field_type\":\"input\", \n" +
        "\"keyboard\":\"text\", \n" +
        "\"required\":true, \n" +
        "\"is_active\":true, \n" +
        "\"icon\":\"https://jemala.png\" }, \n" +
        "{ \n" +
        "\"field_id\":14, \n" +
        "\"hint\":\"Jemali\", \n" +
        "\"field_type\":\"input\", \n" +
        "\"keyboard\":\"text\", \n" +
        "\"required\":false, \n" +
        "\"is_active\":true, \n" +
        "\"icon\":\"https://jemala.png\" }, \n" +
        "{ \n" +
        "\"field_id\":89, \n" +
        "\"hint\":\"Birthday\", \n" +
        "\"field_type\":\"chooser\", \n" +
        "\"required\":false, \n" +
        "\"is_active\":true, \n" +
        "\"icon\":\"https://jemala.png\" }, \n" +
        "{ \n" +
        "\"field_id\":898, \n" +
        "\"hint\":\"Gender\", \n" +
        "\"field_type\":\"chooser\", \n" +
        "\"required\":\"false\", \n" +
        "\"is_active\":true, \n" +
        "\"icon\":\"https://jemala.png\" } \n" +
        "] \n" +
        "]\n"















//var listOfItems = listOf(
//    ListItems(
//        fieldId = 1,
//        hint = "UserName",
//        fieldType = "input",
//        keyboard = "text",
//        required = false,
//        isActive = true,
//        icon = R.drawable.person_icon
//    ),
//
//    ListItems(
//        fieldId = 2,
//        hint = "Email",
//        fieldType = "input",
//        keyboard = "text",
//        required = true,
//        isActive = true,
//        icon = R.drawable.email_icon
//    ),
//
//    ListItems(
//        fieldId = 3,
//        hint = "phone",
//        fieldType = "input",
//        keyboard = "number",
//        required = true,
//        isActive = true,
//        icon = R.drawable.phone_icon
//    ),
//
//    ListItems(
//        fieldId = 4,
//        hint = "FullName",
//        fieldType = "input",
//        keyboard = "text",
//        required = false,
//        isActive = true,
//        icon = R.drawable.person_icon
//    ),
//
//    ListItems(
//        fieldId = 89,
//        hint = "BirthDay",
//        fieldType = "chooser",
//        keyboard = null,
//        required = false,
//        isActive = true,
//        icon = R.drawable.birthday_icon
//    ),
//
//    ListItems(
//        fieldId = 898,
//        hint = "Gender",
//        fieldType = "chooser",
//        keyboard = null,
//        required = false,
//        isActive = true,
//        icon = R.drawable.person_icon
//    )
//)
