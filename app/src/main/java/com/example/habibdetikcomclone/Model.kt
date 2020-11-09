package com.example.habibdetikcomclone


data class Model(var title: String, var desc: String, var photo: Int) {

    object NewsModel{
        val newList = listOf<Model>(
            Model(
                "Lezat Sehat, Ini Menu Sarapan Ariana Grande hingga Selena Gomez",
                "detikcom || 1 jam yang lalu",
                R.drawable.img_news10
            ),

            Model(
                "Kapal nelayan menyalurkan bansos masyarakat Sulawesi",
                "detikcom || 2 jam yang lalu",
                R.drawable.img_news2
            ),

            Model(
                "Macet mulai terjadi di wilayah jalur pemudik",
                "detikcom || 1 jam yang lalu",
                R.drawable.img_news3
            ),

            Model(
                "Jelang new normal Jakarta macet lagi, polisi kewalahan menangani pelanggar",
                "detikcom || 1 jam yang lalu",
                R.drawable.img_news4
            ),

            Model(
                "Wow! Ariana Grande Wanita Pertama dengan 200 Juta Pengikut di Instagram",
                "detikcom || 1 jam yang lalu",
                R.drawable.img_news6
            )

        )

    }
}