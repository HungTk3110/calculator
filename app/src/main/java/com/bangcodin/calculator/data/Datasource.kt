/*
 * *
 *  * Created by Nguyen Van Thai on 9/6/22, 1:26 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/6/22, 1:26 PM
 *
 */

package com.bangcodin.calculator.data

import com.bangcodin.calculator.R
import com.bangcodin.calculator.data.models.*

class Datasource {
    fun loadItem(): List<ItemBottomSheet> {
        return listOf<ItemBottomSheet>(
            ItemBottomSheet(R.string.TvBottomSheet1, R.drawable.ic_currency_conversion),
            ItemBottomSheet(R.string.TvBottomSheet2, R.drawable.ic_exclude),
            ItemBottomSheet(R.string.TvBottomSheet3, R.drawable.ic_kilogram),
            ItemBottomSheet(R.string.TvBottomSheet4, R.drawable.ic_temperature),
        )
    }

    fun loadItemLanguage(): List<ItemLanguage>{
        return listOf<ItemLanguage>(
            ItemLanguage(1,R.string.TvVietNam,R.drawable.ic_vietnam),
            ItemLanguage(2,R.string.TvEnglish, R.drawable.english),
            ItemLanguage(3,R.string.TvIndia, R.drawable.india),
            ItemLanguage(4,R.string.TvIndonesia, R.drawable.indo),
            ItemLanguage(5,R.string.TvPortugal, R.drawable.portugal),
            ItemLanguage(6,R.string.TvKorean, R.drawable.kr),
            ItemLanguage(7,R.string.TvJapan, R.drawable.jp),
            ItemLanguage(8,R.string.TvGermany, R.drawable.germany)
        )
    }

    fun loadItemShare(): List<ItemShare>{
        return listOf<ItemShare>(
            ItemShare(R.string.TvFaceBook, R.drawable.ic_facebook),
            ItemShare(R.string.TvDiscord, R.drawable.ic_discord),
            ItemShare(R.string.TvTelegram, R.drawable.ic_telegram),
            ItemShare(R.string.TvTwitter, R.drawable.ic_twitter),
            ItemShare(R.string.TvMessenger, R.drawable.ic_messenger),
            ItemShare(R.string.TvSkype, R.drawable.ic_skype),
            ItemShare(R.string.TvDropbox, R.drawable.ic_dropbox)
        )
    }

    fun loadItemNational() : List<ItemBottomSheet> {
        return listOf<ItemBottomSheet>(
            ItemBottomSheet(R.string.tv_usd, R.drawable.ic_united_states),
            ItemBottomSheet(R.string.tv_euro, R.drawable.euro),
            ItemBottomSheet(R.string.tv_indian, R.drawable.india),
            ItemBottomSheet(R.string.tv_indo, R.drawable.indo),
            ItemBottomSheet(R.string.tv_korean, R.drawable.kr),
            ItemBottomSheet(R.string.tv_japan, R.drawable.jp),
            ItemBottomSheet(R.string.TvVietNam, R.drawable.ic_vietnam)
        )
    }

    fun loadItemKg(): List<ItemKg>{
        return listOf<ItemKg>(
            ItemKg(R.string.tvKg),
            ItemKg(R.string.tvG),
            ItemKg(R.string.tvTon) ,
            ItemKg(R.string.tvLb),
            ItemKg(R.string.tvOz)
        )
    }

    fun loadItemKm(): List<ItemLength>{
        return  listOf<ItemLength>(
            ItemLength(R.string.tvKm),
            ItemLength(R.string.tvMet),
            ItemLength(R.string.tvMm),
            ItemLength(R.string.tvIn),
            ItemLength(R.string.tvFt),
            ItemLength(R.string.tvYd),
            ItemLength(R.string.tvMi)
        )
    }
}
