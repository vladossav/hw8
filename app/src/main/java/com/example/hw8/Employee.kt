package com.example.hw8

data class Employee(
    val id: Int,
    val name: String,
    val photoUrl: String,
    var liked: Boolean = false
) {
    companion object {
       fun getMockEmployees() = listOf(
           Employee(1,"Тим Кук","https://www.iphones.ru/wp-content/uploads/2019/09/43F01D3C-38BA-4BBA-8174-5C42401605B4.jpeg"),
           Employee(2,"Ларри Пейдж","http://top5-top10.ru/wp-content/uploads/2019/05/Ларри-Пейдж.jpg"),
           Employee(3,"Сергей Брин","https://www.coinwire.com/wp-content/uploads/google-sergey-brin-9969.jpg"),
           Employee(4,"Марк Цукерберг","https://i1.wp.com/cdn.7sisters.ru/wp-content/uploads/2017/02/Mark-Zuckerberg.jpg"),
           Employee(5,"Павел Дуров","https://www.oum.ru/upload/iblock/321/321f3c7314bb736c5fce287143264168.jpg"),
           Employee(6,"Аркадий Волож","https://m.seonews.ru/upload/iblock/c23/c233d6d2d9cbc5afeecd48a0151ded12.jpg"),
           Employee(7,"Андрей Дороничев","https://storage.yandexcloud.net/incrussia-prod/wp-content/uploads/2020/03/Cover_600-6.jpg"),
           Employee(8,"Виталик Бутерин","https://data-to-data.ru/wp-content/uploads/2018/10/1539504904_vitalik-buterin-nazval-razmer-svoego-sostoyaniya.jpg"),
           Employee(9,"Юрий Мильнер","https://ic.pics.livejournal.com/ecort/32937544/240995/240995_original.jpg"),
           Employee(10,"Илон Маск","https://simpleslim.ru/wp-content/uploads/2022/01/elon-musk.jpeg"),
           Employee(11,"Олег Тиньков","https://globalmsk.ru/usr/upload/15325112930.jpg"),
           Employee(12,"Михаил Фридман","https://profitgate.ru/upload/000/u32/f/2/asder2_479a511b48603ba15e6b456f1ff216c5.jpg")
           )
    }
}


