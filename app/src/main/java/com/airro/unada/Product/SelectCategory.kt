package com.airro.unada.Product

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.airro.unada.R

class SelectCategory : AppCompatActivity() {

    private lateinit var gangnambtn: Button
    private lateinit var gangdongbtn: Button
    private lateinit var gangbukbtn: Button
    private lateinit var gangsubtn: Button
    private lateinit var gangakbtn : Button
    private lateinit var gangjinbtn: Button
    private lateinit var gurobtn: Button
    private lateinit var geumcheonbtn: Button
    private lateinit var nowonbtn: Button
    private lateinit var dobongbtn: Button
    private lateinit var dongdaemunbtn: Button
    private lateinit var dongjakbtn: Button
    private lateinit var mapobtn: Button
    private lateinit var seodaemunbtn: Button
    private lateinit var seochobtn: Button
    private lateinit var seongdongbtn: Button
    private lateinit var seongbukbtn: Button
    private lateinit var songpabtn: Button
    private lateinit var yangcheonbtn: Button
    private lateinit var yeongdeungpobtn: Button
    private lateinit var yongsanbtn: Button
    private lateinit var eunpyeongbtn: Button
    private lateinit var jongnobtn: Button
    private lateinit var jungbtn: Button
    private lateinit var jungnangbtn: Button

    private lateinit var deogyanggubtn: Button
    private lateinit var ilsandonggubtn: Button
    private lateinit var ilsansugubtn: Button
    private lateinit var gwacheonbtn: Button
    private lateinit var gwangmyeongbtn: Button
    private lateinit var gwangjusibtn: Button
    private lateinit var guribtn: Button
    private lateinit var gunpobtn: Button
    private lateinit var gimpobtn: Button
    private lateinit var namyangjubtn: Button
    private lateinit var dongducheonbtn: Button
    private lateinit var bucheonbtn: Button
    private lateinit var bundangbtn: Button
    private lateinit var sujeongbtn: Button
    private lateinit var jungwonbtn: Button
    private lateinit var gwonseonbtn: Button
    private lateinit var yeongtongbtn: Button
    private lateinit var janganbtn: Button
    private lateinit var paldalbtn: Button
    private lateinit var siheungbtn: Button
    private lateinit var danwonbtn: Button
    private lateinit var sangnokbtn: Button
    private lateinit var anseongbtn: Button
    private lateinit var donganbtn: Button
    private lateinit var mananbtn: Button
    private lateinit var yangjubtn: Button
    private lateinit var yeojubtn: Button
    private lateinit var osanbtn: Button
    private lateinit var giheungbtn : Button
    private lateinit var sujibtn: Button
    private lateinit var cheoinbtn: Button
    private lateinit var uiwangbtn: Button
    private lateinit var uijeongbubtn: Button
    private lateinit var icheonbtn: Button
    private lateinit var pajubtn: Button
    private lateinit var pyeongtaekbtn: Button
    private lateinit var pocheonbtn: Button
    private lateinit var hanambtn: Button
    private lateinit var hwaseongbtn: Button

    private lateinit var gangseobtn: Button
    private lateinit var geumjeongbtn: Button
    private lateinit var gijangbtn : Button
    private lateinit var bnambtn : Button
    private lateinit var bdongbtn: Button
    private lateinit var dongnaebtn: Button
    private lateinit var busanjinbtn: Button
    private lateinit var bbukbtn: Button
    private lateinit var sasangbtn: Button
    private lateinit var sahabtn: Button
    private lateinit var bseobtn: Button
    private lateinit var suyeongbtn: Button
    private lateinit var yeonjebtn: Button
    private lateinit var yeongdobtn: Button
    private lateinit var bzongbtn: Button
    private lateinit var haeundaebtn : Button

    private lateinit var gyeyangbtn: Button
    private lateinit var namdongbtn: Button
    private lateinit var idongbtn: Button
    private lateinit var michuholbtn: Button
    private lateinit var bupyeongbtn: Button
    private lateinit var iseobtn: Button
    private lateinit var yeonsubtn: Button
    private lateinit var ijungbtn: Button
    private lateinit var ganghwabtn: Button
    private lateinit var ongjinbtn: Button

    private lateinit var gwangsangubtn: Button
    private lateinit var namgubtn: Button
    private lateinit var donggubtn: Button
    private lateinit var bukgubtn: Button
    private lateinit var seogubtn: Button

    private lateinit var gunwibtn: Button
    private lateinit var daegunambtn: Button
    private lateinit var dalseobtn: Button
    private lateinit var dalseongbtn: Button
    private lateinit var daehudongbtn: Button
    private lateinit var daegubukbtn: Button
    private lateinit var daeguseobtn: Button
    private lateinit var suseongbtn: Button
    private lateinit var daegujungbtn: Button

    private lateinit var daedeokbtn: Button
    private lateinit var ddongbtn: Button
    private lateinit var dseobtn: Button
    private lateinit var yuseongbtn: Button
    private lateinit var djungbtn: Button

    private lateinit var gangneungbtn: Button
    private lateinit var donghaebtn: Button
    private lateinit var samcheokbtn: Button
    private lateinit var sokchobtn: Button
    private lateinit var wonjubtn: Button
    private lateinit var chuncheonbtn: Button
    private lateinit var taebaekbtn: Button

    private lateinit var goesanbtn: Button
    private lateinit var danyangbtn: Button
    private lateinit var boeunbtn: Button
    private lateinit var yeongdongbtn: Button
    private lateinit var okcheonbtn: Button
    private lateinit var eumseongbtn: Button
    private lateinit var jeungpyeongbtn: Button
    private lateinit var jincheonbtn: Button
    private lateinit var jecheonbtn: Button
    private lateinit var cheongjubtn: Button
    private lateinit var chungjubtn: Button

    private lateinit var gyeryongbtn: Button
    private lateinit var gongjubtn: Button
    private lateinit var geumsanbtn: Button
    private lateinit var nonsanbtn: Button
    private lateinit var dangjinbtn: Button
    private lateinit var boryeongbtn: Button
    private lateinit var buyeobtn: Button
    private lateinit var seosanbtn: Button
    private lateinit var seocheonbtn: Button
    private lateinit var asanbtn: Button
    private lateinit var yesanbtn: Button
    private lateinit var cheonanbtn: Button
    private lateinit var cheongyangbtn: Button
    private lateinit var taeanbtn: Button
    private lateinit var hongseongbtn: Button

    private lateinit var Gyeongsanbtn: Button
    private lateinit var Gyeongjubtn: Button
    private lateinit var Gumibtn: Button
    private lateinit var Gimcheonbtn: Button
    private lateinit var Mungyeongbtn: Button
    private lateinit var Sangjubtn: Button
    private lateinit var Andongbtn: Button
    private lateinit var Yeongjubtn: Button
    private lateinit var Yeongcheonbtn: Button
    private lateinit var Pohangbtn: Button

    private lateinit var Geojebtn: Button
    private lateinit var Gimhaebtn: Button
    private lateinit var Miryangbtn: Button
    private lateinit var Sacheonbtn: Button
    private lateinit var Yangsanbtn: Button
    private lateinit var Jinjubtn: Button
    private lateinit var Changwonbtn: Button
    private lateinit var Tongyeongbtn: Button

    private lateinit var Gunsanbtn: Button
    private lateinit var Gimjebtn: Button
    private lateinit var Namwonbtn: Button
    private lateinit var Iksanbtn: Button
    private lateinit var Jeonjubtn: Button
    private lateinit var Jeongeupbtn: Button

    private lateinit var Gwangyangbtn: Button
    private lateinit var Najubtn: Button
    private lateinit var Mokpobtn: Button
    private lateinit var Suncheonbtn: Button
    private lateinit var Yeosubtn: Button

    private lateinit var olsannambtn: Button
    private lateinit var olsandongbtn: Button
    private lateinit var olsanbukbtn: Button
    private lateinit var Uljubtn: Button
    private lateinit var olsanjungbtn: Button

    private lateinit var Seogwipobtn: Button
    private lateinit var Jejucitybtn: Button

    private lateinit var sejongallbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chooselocation)
        val seoulbutton = findViewById<Button>(R.id.seoul)
        val whiteseoulbutton = findViewById<Button>(R.id.whiteseoul)
        val gyeonggibutton = findViewById<Button>(R.id.gyeonggi)
        val whitegyeonggibutton = findViewById<Button>(R.id.whitegyeonggi)
        val incheonbutton = findViewById<Button>(R.id.incheon)
        val whiteincheonbutton = findViewById<Button>(R.id.whiteincheon)
        val busanbutton = findViewById<Button>(R.id.busan)
        val whitebusanbutton = findViewById<Button>(R.id.whitebusan)
        val daejeonbutton = findViewById<Button>(R.id.daejeon)
        val whitedaejeonbutton = findViewById<Button>(R.id.whitedaejeon)
        val daegubutton = findViewById<Button>(R.id.daegu)
        val whitedaegubutton = findViewById<Button>(R.id.whitedaegu)
        val gwangjubutton = findViewById<Button>(R.id.gwangju)
        val whitegwangjubutton = findViewById<Button>(R.id.whitegwangju)
        val gwangwonbutton = findViewById<Button>(R.id.gwangwon)
        val whitegwangwonbutton = findViewById<Button>(R.id.whitegwanwon)
        val sejongbutton = findViewById<Button>(R.id.sejong)
        val whitesejongbutton = findViewById<Button>(R.id.whitesejong)
        val chungbukbutton = findViewById<Button>(R.id.chungbuk)
        val whitechungbukbutton = findViewById<Button>(R.id.whitechungbuk)
        val chungnambutton = findViewById<Button>(R.id.chungnam)
        val whitechungnambutton = findViewById<Button>(R.id.whitechungnam)
        val gyeongbukbutton = findViewById<Button>(R.id.gyeongbuk)
        val whitegyeongbukbutton = findViewById<Button>(R.id.whitegyeongbuk)
        val gyeongnambutton = findViewById<Button>(R.id.gyeongnam)
        val whitegyeongnambutton = findViewById<Button>(R.id.whitegyeongnam)
        val jeonbukbutton = findViewById<Button>(R.id.jeonbuk)
        val whitejeonbukbutton = findViewById<Button>(R.id.whitejeonbuk)
        val jeonnambutton = findViewById<Button>(R.id.jeonnam)
        val whitejeonnambutton = findViewById<Button>(R.id.whitejeonnam)
        val ulsanbutton = findViewById<Button>(R.id.ulsan)
        val whiteulsanbutton = findViewById<Button>(R.id.whiteulsan)
        val jejubutton = findViewById<Button>(R.id.jeju)
        val whitejejubutton = findViewById<Button>(R.id.whitejeju)


        gangnambtn = findViewById<Button>(R.id.gangnam)
        gangdongbtn = findViewById<Button>(R.id.gangdong)
        gangbukbtn = findViewById<Button>(R.id.gangbuk)
        gangsubtn = findViewById<Button>(R.id.gangsu)
        gangakbtn = findViewById<Button>(R.id.gangak)
        gangjinbtn = findViewById<Button>(R.id.gangjin)
        gurobtn = findViewById<Button>(R.id.guro)
        geumcheonbtn = findViewById<Button>(R.id.geumcheon)
        nowonbtn = findViewById<Button>(R.id.nowon)
        dobongbtn = findViewById<Button>(R.id.dobong)
        dongdaemunbtn = findViewById<Button>(R.id.dongdaemun)
        dongjakbtn = findViewById<Button>(R.id.dongjak)
        mapobtn = findViewById<Button>(R.id.mapo)
        seodaemunbtn = findViewById<Button>(R.id.seodaemun)
        seochobtn = findViewById<Button>(R.id.seocho)
        seongdongbtn = findViewById<Button>(R.id.seongdong)
        seongbukbtn = findViewById<Button>(R.id.seongbuk)
        songpabtn = findViewById<Button>(R.id.songpa)
        yangcheonbtn = findViewById<Button>(R.id.yangcheon)
        yeongdeungpobtn = findViewById<Button>(R.id.yeongdeungpo)
        yongsanbtn = findViewById<Button>(R.id.yongsan)
        eunpyeongbtn = findViewById<Button>(R.id.eunpyeong)
        jongnobtn = findViewById<Button>(R.id.jongno)
        jungbtn = findViewById<Button>(R.id.jung)
        jungnangbtn = findViewById<Button>(R.id.jungnang)

        deogyanggubtn = findViewById<Button>(R.id.deogyanggu)
        ilsandonggubtn = findViewById<Button>(R.id.ilsandonggu)
        ilsansugubtn = findViewById<Button>(R.id.ilsansugu)
        gwacheonbtn = findViewById<Button>(R.id.gwacheon)
        gwangmyeongbtn = findViewById<Button>(R.id.gwangmyeong)
        gwangjusibtn = findViewById<Button>(R.id.gwangjusi)
        guribtn = findViewById<Button>(R.id.guri)
        gunpobtn = findViewById<Button>(R.id.gunpo)
        gimpobtn = findViewById<Button>(R.id.gimpo)
        namyangjubtn = findViewById<Button>(R.id.namyangju)
        dongducheonbtn = findViewById<Button>(R.id.dongducheon)
        bucheonbtn = findViewById<Button>(R.id.bucheon)
        bundangbtn = findViewById<Button>(R.id.bundang)
        sujeongbtn = findViewById<Button>(R.id.sujeong)
        jungwonbtn = findViewById<Button>(R.id.jungwon)
        gwonseonbtn = findViewById<Button>(R.id.gwonseon)
        yeongtongbtn = findViewById<Button>(R.id.yeongtong)
        janganbtn = findViewById<Button>(R.id.jangan)
        paldalbtn = findViewById<Button>(R.id.paldal)
        siheungbtn = findViewById<Button>(R.id.siheung)
        danwonbtn = findViewById<Button>(R.id.danwon)
        sangnokbtn = findViewById<Button>(R.id.sangnok)
        anseongbtn = findViewById<Button>(R.id.anseong)
        donganbtn = findViewById<Button>(R.id.dongan)
        mananbtn = findViewById<Button>(R.id.manan)
        yangjubtn = findViewById<Button>(R.id.yangju)
        yeojubtn = findViewById<Button>(R.id.yeoju)
        osanbtn = findViewById<Button>(R.id.osan)
        giheungbtn = findViewById<Button>(R.id.giheung)
        sujibtn = findViewById<Button>(R.id.suji)
        cheoinbtn = findViewById<Button>(R.id.cheoin)
        uiwangbtn = findViewById<Button>(R.id.uiwang)
        uijeongbubtn = findViewById<Button>(R.id.uijeongbu)
        icheonbtn = findViewById<Button>(R.id.icheon)
        pajubtn = findViewById<Button>(R.id.paju)
        pyeongtaekbtn = findViewById<Button>(R.id.pyeongtaek)
        pocheonbtn = findViewById<Button>(R.id.pocheon)
        hanambtn = findViewById<Button>(R.id.hanam)
        hwaseongbtn = findViewById<Button>(R.id.hwaseong)



        gyeyangbtn = findViewById<Button>(R.id.gyeyang)
        namdongbtn = findViewById<Button>(R.id.namdong)
        idongbtn = findViewById<Button>(R.id.idong)
        michuholbtn = findViewById<Button>(R.id.michuhol)
        bupyeongbtn = findViewById<Button>(R.id.bupyeong)
        iseobtn = findViewById<Button>(R.id.iseo)
        yeonsubtn = findViewById<Button>(R.id.yeonsu)
        ijungbtn = findViewById<Button>(R.id.ijung)
        ganghwabtn = findViewById<Button>(R.id.ganghwa)
        ongjinbtn = findViewById<Button>(R.id.ongjin)


        gangseobtn = findViewById(R.id.gangseo)
        geumjeongbtn = findViewById(R.id.geumjeong)
        gijangbtn = findViewById(R.id.gijang)
        bnambtn = findViewById(R.id.bnam)
        bdongbtn = findViewById<Button>(R.id.bdong)
        dongnaebtn = findViewById<Button>(R.id.dongnae)
        busanjinbtn = findViewById<Button>(R.id.busanjin)
        bbukbtn = findViewById<Button>(R.id.bbuk)
        sasangbtn = findViewById<Button>(R.id.sasang)
        sahabtn = findViewById<Button>(R.id.saha)
        bseobtn = findViewById<Button>(R.id.bseo)
        suyeongbtn = findViewById<Button>(R.id.suyeong)
        yeonjebtn = findViewById<Button>(R.id.yeonje)
        yeongdobtn = findViewById<Button>(R.id.yeongdo)
        bzongbtn = findViewById<Button>(R.id.bzong)
        haeundaebtn = findViewById<Button>(R.id.haeundae)

        daedeokbtn = findViewById<Button>(R.id.daedeok)
        ddongbtn = findViewById<Button>(R.id.ddong)
        dseobtn = findViewById<Button>(R.id.dseo)
        yuseongbtn = findViewById<Button>(R.id.yuseong)
        djungbtn = findViewById<Button>(R.id.djung)

        gunwibtn = findViewById<Button>(R.id.gunwi)
        daegunambtn = findViewById<Button>(R.id.daegunam)
        dalseobtn = findViewById<Button>(R.id.dalseo)
        dalseongbtn = findViewById<Button>(R.id.dalseong)
        daehudongbtn = findViewById<Button>(R.id.daehudong)
        daegubukbtn = findViewById<Button>(R.id.daegubuk)
        daeguseobtn = findViewById<Button>(R.id.daeguseo)
        suseongbtn = findViewById<Button>(R.id.suseong)
        daegujungbtn = findViewById<Button>(R.id.daegujung)

        gwangsangubtn = findViewById<Button>(R.id.gwangsangu)
        namgubtn = findViewById<Button>(R.id.namgu)
        donggubtn = findViewById<Button>(R.id.donggu)
        bukgubtn = findViewById<Button>(R.id.bukgu)
        seogubtn = findViewById<Button>(R.id.seogu)

        gangneungbtn = findViewById<Button>(R.id.gangneung)
        donghaebtn = findViewById<Button>(R.id.donghae)
        samcheokbtn = findViewById<Button>(R.id.samcheok)
        sokchobtn = findViewById<Button>(R.id.sokcho)
        wonjubtn = findViewById<Button>(R.id.wonju)
        chuncheonbtn = findViewById<Button>(R.id.chuncheon)
        taebaekbtn = findViewById<Button>(R.id.taebaek)

        goesanbtn = findViewById<Button>(R.id.goesan)
        danyangbtn = findViewById<Button>(R.id.danyang)
        boeunbtn = findViewById<Button>(R.id.boeun)
        yeongdongbtn = findViewById<Button>(R.id.yeongdong)
        okcheonbtn = findViewById<Button>(R.id.okcheon)
        eumseongbtn = findViewById<Button>(R.id.eumseong)
        jeungpyeongbtn = findViewById<Button>(R.id.jeungpyeong)
        jincheonbtn = findViewById<Button>(R.id.jincheon)
        jecheonbtn = findViewById<Button>(R.id.jecheon)
        cheongjubtn = findViewById<Button>(R.id.cheongju)
        chungjubtn = findViewById<Button>(R.id.chungju)

        gyeryongbtn = findViewById<Button>(R.id.gyeryong)
        gongjubtn = findViewById<Button>(R.id.gongju)
        geumsanbtn = findViewById<Button>(R.id.geumsan)
        nonsanbtn = findViewById<Button>(R.id.nonsan)
        dangjinbtn = findViewById<Button>(R.id.dangjin)
        boryeongbtn = findViewById<Button>(R.id.boryeong)
        buyeobtn = findViewById<Button>(R.id.buyeo)
        seosanbtn = findViewById<Button>(R.id.seosan)
        seocheonbtn = findViewById<Button>(R.id.seocheon)
        asanbtn = findViewById<Button>(R.id.asan)
        yesanbtn = findViewById<Button>(R.id.yesan)
        cheonanbtn = findViewById<Button>(R.id.cheonan)
        cheongyangbtn = findViewById<Button>(R.id.cheongyang)
        taeanbtn = findViewById<Button>(R.id.taean)
        hongseongbtn = findViewById<Button>(R.id.hongseong)

        Gyeongsanbtn = findViewById<Button>(R.id.Gyeongsan)
        Gyeongjubtn = findViewById<Button>(R.id.Gyeongju)
        Gumibtn = findViewById<Button>(R.id.Gumi)
        Gimcheonbtn = findViewById<Button>(R.id.Gimcheon)
        Mungyeongbtn = findViewById<Button>(R.id.Mungyeong)
        Sangjubtn = findViewById<Button>(R.id.Sangju)
        Andongbtn = findViewById<Button>(R.id.Andong)
        Yeongjubtn = findViewById<Button>(R.id.Yeongju)
        Yeongcheonbtn = findViewById<Button>(R.id.Yeongcheon)
        Pohangbtn = findViewById<Button>(R.id.Pohang)


        Geojebtn = findViewById<Button>(R.id.Geoje)
        Gimhaebtn = findViewById<Button>(R.id.Gimhae)
        Miryangbtn = findViewById<Button>(R.id.Miryang)
        Sacheonbtn = findViewById<Button>(R.id.Sacheon)
        Yangsanbtn = findViewById<Button>(R.id.Yangsan)
        Jinjubtn = findViewById<Button>(R.id.Jinju)
        Changwonbtn = findViewById<Button>(R.id.Changwon)
        Tongyeongbtn = findViewById<Button>(R.id.Tongyeong)

        Gunsanbtn = findViewById<Button>(R.id.Gunsan)
        Gimjebtn = findViewById<Button>(R.id.Gimje)
        Namwonbtn = findViewById<Button>(R.id.Namwon)
        Iksanbtn = findViewById<Button>(R.id.Iksan)
        Jeonjubtn = findViewById<Button>(R.id.Jeonju)
        Jeongeupbtn = findViewById<Button>(R.id.Jeongeup)

        Gwangyangbtn = findViewById<Button>(R.id.Gwangyang)
        Najubtn = findViewById<Button>(R.id.Naju)
        Mokpobtn = findViewById<Button>(R.id.Mokpo)
        Suncheonbtn = findViewById<Button>(R.id.Suncheon)
        Yeosubtn = findViewById<Button>(R.id.Yeosu)

        olsannambtn = findViewById<Button>(R.id.olsannam)
        olsandongbtn = findViewById<Button>(R.id.olsandong)
        olsanbukbtn = findViewById<Button>(R.id.olsanbuk)
        Uljubtn = findViewById<Button>(R.id.Ulju)
        olsanjungbtn = findViewById<Button>(R.id.olsanjung)


        Seogwipobtn = findViewById<Button>(R.id.Seogwipo)
        Jejucitybtn = findViewById<Button>(R.id.Jejucity)

        sejongallbtn = findViewById<Button>(R.id.sejongall)


        whiteseoulbutton.visibility = View.INVISIBLE
        whitegyeonggibutton.visibility = View.INVISIBLE
        whiteincheonbutton.visibility = View.INVISIBLE
        whitebusanbutton.visibility = View.INVISIBLE
        whitedaejeonbutton.visibility = View.INVISIBLE
        whitedaegubutton.visibility = View.INVISIBLE
        whitegwangjubutton.visibility = View.INVISIBLE
        whitegwangwonbutton.visibility = View.INVISIBLE
        whitesejongbutton.visibility = View.INVISIBLE
        whitechungbukbutton.visibility = View.INVISIBLE
        whitechungnambutton.visibility = View.INVISIBLE
        whitegyeongbukbutton.visibility = View.INVISIBLE
        whitegyeongnambutton.visibility = View.INVISIBLE
        whitejeonbukbutton.visibility = View.INVISIBLE
        whitejeonnambutton.visibility = View.INVISIBLE
        whiteulsanbutton.visibility = View.INVISIBLE
        whitejejubutton.visibility = View.INVISIBLE




        hideseoul()

        hidegyeonggi()

        hiedincheon()

        hidebusan()

        hidedaejeon()

        hidedaegu()

        hidegwangju()

        hidegwangwon()

        hidechunhbuk()

        hidechungnam()

        hidegyeongbuk()

        hidegyeongnam()

        hidejeonbuk()

        hidejeonnam()

        hideulsan()

        hidejeju()

        hidesejong()

        seoulbutton.setOnClickListener {

            seoulbutton.visibility = View.INVISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.VISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE



            showseoul()


            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        gyeonggibutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.INVISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.VISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            showgyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        incheonbutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.INVISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.VISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hidebusan()

            showincheon()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }


        busanbutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.INVISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.VISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            showbusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }


        daejeonbutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.INVISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.VISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            showdaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        daegubutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.INVISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.VISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            showdaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        gwangjubutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.INVISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.VISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            showgwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        gwangwonbutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.INVISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.VISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            showgwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        sejongbutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.INVISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.VISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            showsejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }



        chungbukbutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.INVISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.VISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            showchunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        chungnambutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.INVISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.VISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            showchungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        gyeongnambutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.INVISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.VISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            showgyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        gyeongbukbutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.INVISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.VISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            showgyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        jeonbukbutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.INVISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.VISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            showjeonbuk()

            hidejeonnam()

            hideulsan()

            hidejeju()
        }

        jeonnambutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.INVISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.VISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            showjeonnam()

            hideulsan()

            hidejeju()
        }



        ulsanbutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.INVISIBLE
            jejubutton.visibility = View.VISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.VISIBLE
            whitejejubutton.visibility = View.INVISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            showulsan()

            hidejeju()
        }

        jejubutton.setOnClickListener {

            seoulbutton.visibility = View.VISIBLE
            gyeonggibutton.visibility = View.VISIBLE
            incheonbutton.visibility = View.VISIBLE
            busanbutton.visibility = View.VISIBLE
            daejeonbutton.visibility = View.VISIBLE
            daegubutton.visibility = View.VISIBLE
            gwangjubutton.visibility = View.VISIBLE
            gwangwonbutton.visibility = View.VISIBLE
            sejongbutton.visibility = View.VISIBLE
            chungbukbutton.visibility = View.VISIBLE
            chungnambutton.visibility = View.VISIBLE
            gyeongbukbutton.visibility = View.VISIBLE
            gyeongnambutton.visibility = View.VISIBLE
            jeonbukbutton.visibility = View.VISIBLE
            jeonnambutton.visibility = View.VISIBLE
            ulsanbutton.visibility = View.VISIBLE
            jejubutton.visibility = View.INVISIBLE
            whiteseoulbutton.visibility = View.INVISIBLE
            whitegyeonggibutton.visibility = View.INVISIBLE
            whiteincheonbutton.visibility = View.INVISIBLE
            whitebusanbutton.visibility = View.INVISIBLE
            whitedaejeonbutton.visibility = View.INVISIBLE
            whitedaegubutton.visibility = View.INVISIBLE
            whitegwangjubutton.visibility = View.INVISIBLE
            whitegwangwonbutton.visibility = View.INVISIBLE
            whitesejongbutton.visibility = View.INVISIBLE
            whitechungbukbutton.visibility = View.INVISIBLE
            whitechungnambutton.visibility = View.INVISIBLE
            whitegyeongbukbutton.visibility = View.INVISIBLE
            whitegyeongnambutton.visibility = View.INVISIBLE
            whitejeonbukbutton.visibility = View.INVISIBLE
            whitejeonnambutton.visibility = View.INVISIBLE
            whiteulsanbutton.visibility = View.INVISIBLE
            whitejejubutton.visibility = View.VISIBLE


            hideseoul()

            hidegyeonggi()

            hiedincheon()

            hidebusan()

            hidedaejeon()

            hidedaegu()

            hidegwangju()

            hidegwangwon()

            hidesejong()

            hidechunhbuk()

            hidechungnam()

            hidegyeongbuk()

            hidegyeongnam()

            hidejeonbuk()

            hidejeonnam()

            hideulsan()

            showjeju()
        }


        gangnambtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 강남구")
            startActivity(intent)
        }

        gangdongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 강동구")
            startActivity(intent)

        }

        gangbukbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 강북구")
            startActivity(intent)

        }

        gangsubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 강서구")
                        startActivity(intent)

        }

        gangakbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 관악구")
                        startActivity(intent)

        }

        gangjinbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 광진")
                        startActivity(intent)

        }

        gurobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 구로구")
                        startActivity(intent)

        }

        geumcheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 금천구")
                        startActivity(intent)

        }

        nowonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 노원구")
                        startActivity(intent)

        }

        dobongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 도봉구")
                        startActivity(intent)

        }

        dongdaemunbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 동대문구")
                        startActivity(intent)

        }

        dongjakbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 동작구")
                        startActivity(intent)

        }

        mapobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 마포구")
                        startActivity(intent)

        }

        seodaemunbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 서대문구")
                        startActivity(intent)

        }

        seochobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 서초구")
                        startActivity(intent)

        }

        seongdongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 성동구")
                        startActivity(intent)

        }

        seongbukbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 성북구")
                        startActivity(intent)

        }

        songpabtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 송파구")
                        startActivity(intent)

        }

        yangcheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 양천구")
                        startActivity(intent)

        }

        yeongdeungpobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 영등포구")
                        startActivity(intent)

        }

        yongsanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 용산구")
                        startActivity(intent)

        }

        eunpyeongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 은평구")
                        startActivity(intent)

        }

        jongnobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 종로구")
                        startActivity(intent)

        }

        jungbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 중구")
                        startActivity(intent)

        }

        jungnangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "서울 중랑구")
                        startActivity(intent)

        }

        deogyanggubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "경기 고양시 덕양구")
                        startActivity(intent)

        }

        ilsandonggubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "경기 고양시 일산동구")
                        startActivity(intent)

        }

        ilsansugubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "경기 고양시 일산서구")
                        startActivity(intent)

        }

        gwacheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "경기 과천시")
                        startActivity(intent)

        }

        gwangmyeongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "경기 광명시")
                        startActivity(intent)

        }

        gwangjusibtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)
            intent.putExtra("location", "경기 광주시")
                        startActivity(intent)

        }

        guribtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 구리시")
                        startActivity(intent)

        }

        gunpobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 군포시")
                        startActivity(intent)

        }

        gimpobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 김포시")
                        startActivity(intent)

        }

        namyangjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 남양주시")
                        startActivity(intent)

        }

        dongducheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 동두천시")
                        startActivity(intent)

        }

        bucheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 부천시")
                        startActivity(intent)

        }

        bundangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 성남시 분당구")
                        startActivity(intent)

        }

        sujeongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 성남시 수정구")
                        startActivity(intent)

        }

        jungwonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 성남시 중원구")
                        startActivity(intent)

        }

        gwonseonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 수원시 권선구")
                        startActivity(intent)

        }

        yeongtongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 수원시 영통구")
                        startActivity(intent)

        }

        janganbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 수원시 장안구")
                        startActivity(intent)

        }

        paldalbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 수원시 팔달구")
                        startActivity(intent)

        }

        siheungbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 시흥시")
                        startActivity(intent)

        }

        danwonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 안산시 단원구")
                        startActivity(intent)

        }

        sangnokbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 안산시 상록구")
                        startActivity(intent)

        }

        anseongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 안성시")
                        startActivity(intent)

        }

        donganbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 안양시 동안구")
                        startActivity(intent)

        }

        mananbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 안양시 만안구")
                        startActivity(intent)

        }

        yangjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 양주시")
                        startActivity(intent)

        }

        yeojubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 여주시")
                        startActivity(intent)

        }

        osanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 오산시")
                        startActivity(intent)

        }

        giheungbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 용인시 기흥구")
                        startActivity(intent)

        }

        sujibtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 용인시 수지구")
                        startActivity(intent)

        }

        cheoinbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 용인시 처인구")
                        startActivity(intent)

        }

        uiwangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 의왕시")
                        startActivity(intent)

        }

        uijeongbubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 의정부시")
                        startActivity(intent)

        }

        icheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 이천시")
                        startActivity(intent)

        }

        pajubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 파주시")
                        startActivity(intent)

        }

        pyeongtaekbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 평택시")
                        startActivity(intent)

        }

        pocheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 포천시")
                        startActivity(intent)

        }

        hanambtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 하남시")
                        startActivity(intent)

        }

        hwaseongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경기 화성시")
                        startActivity(intent)

        }

        gyeyangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "인천 계양구")
                        startActivity(intent)

        }

        namdongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "인천 남동구")
                        startActivity(intent)

        }

        idongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "인천 동구")
                        startActivity(intent)

        }

        michuholbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "인천 미추홀구")
                        startActivity(intent)

        }

        bupyeongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "인천 부평구")
                        startActivity(intent)

        }

        iseobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "인천 서구")
                        startActivity(intent)

        }

        yeonsubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "인천 연수구")
                        startActivity(intent)

        }


        ijungbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "인천 중구")
                        startActivity(intent)

        }

        ganghwabtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "인천 강화군")
                        startActivity(intent)

        }

        ongjinbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "인천 웅진군")
                        startActivity(intent)

        }

        gangseobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 강서구")
                        startActivity(intent)

        }

        geumjeongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 금정구")
                        startActivity(intent)

        }

        gijangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 기장군")
                        startActivity(intent)

        }

        bnambtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 남구")
                        startActivity(intent)

        }

        bdongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 동구")
                        startActivity(intent)

        }

        dongnaebtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 동래구")
                        startActivity(intent)

        }

        busanjinbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 부산진구")
                        startActivity(intent)

        }

        bbukbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 북구")
                        startActivity(intent)

        }

        sasangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 사상구")
                        startActivity(intent)

        }

        sahabtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 사하구")
                        startActivity(intent)

        }

        bseobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 서구")
                        startActivity(intent)

        }

        suyeongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 수영구")
                        startActivity(intent)

        }

        yeonjebtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 연제구")
                        startActivity(intent)

        }

        yeongdobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 영도구")
                        startActivity(intent)

        }

        bzongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 중구")
                        startActivity(intent)

        }

        haeundaebtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "부산 해운대구")
                        startActivity(intent)

        }

        daedeokbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대전 대덕구")
                        startActivity(intent)

        }

        gunwibtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대구 군위구")
                        startActivity(intent)

        }

        daegunambtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대구 남구")
                        startActivity(intent)

        }

        dalseobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대구 달서구")
                        startActivity(intent)

        }

        dalseongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대구 달성군")
                        startActivity(intent)

        }

        daehudongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대구 동구")
                        startActivity(intent)

        }

        daegubukbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대구 북구")
                        startActivity(intent)

        }

        daeguseobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대구 서구")
                        startActivity(intent)

        }

        suseongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대구 수성구")
                        startActivity(intent)

        }

        daegujungbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대구 중구")
                        startActivity(intent)

        }

        ddongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대전 동구")
                        startActivity(intent)

        }

        dseobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대전 달서구")
                        startActivity(intent)

        }

        yuseongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대전 유성구")
                        startActivity(intent)

        }

        djungbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "대전 중구")
                        startActivity(intent)

        }

        gwangsangubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "광주 광산구")
                        startActivity(intent)

        }

        namgubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "광주 남구")
                        startActivity(intent)

        }

        donggubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "광주 동구")
                        startActivity(intent)

        }

        bukgubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "광주 북구")
                        startActivity(intent)

        }

        seogubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "광주 서구")
                        startActivity(intent)

        }

        gangneungbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "강원 강릉시")
                        startActivity(intent)

        }

        donghaebtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "강원 동해시")
                        startActivity(intent)

        }

        samcheokbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "강원 삼척시")
                        startActivity(intent)

        }

        sokchobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "강원 속초시")
                        startActivity(intent)

        }

        wonjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "강원 원주시")
                        startActivity(intent)

        }

        chuncheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "강원 춘천시")
                        startActivity(intent)

        }

        taebaekbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "강원 태백시")
                        startActivity(intent)

        }


        goesanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 괴산군")
                        startActivity(intent)

        }

        danyangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 단양군")
                        startActivity(intent)

        }

        boeunbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 보은군")
                        startActivity(intent)

        }

        yeongdongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 영동군")
                        startActivity(intent)

        }

        okcheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 옥천군")
                        startActivity(intent)

        }

        eumseongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 음성군")
                        startActivity(intent)

        }

        jeungpyeongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 증평군")
                        startActivity(intent)

        }

        jincheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 진천군")
                        startActivity(intent)

        }

        jecheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 제천시")
                        startActivity(intent)

        }

        cheongjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 청주시")
                        startActivity(intent)

        }

        chungjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충북 충주시")
                        startActivity(intent)

        }
        //
        gyeryongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 계룡시")
                        startActivity(intent)

        }

        gongjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 공주시")
                        startActivity(intent)

        }

        geumsanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 금산군")
                        startActivity(intent)

        }


        nonsanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 논산시")
                        startActivity(intent)

        }

        dangjinbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 당진시")
                        startActivity(intent)

        }

        boryeongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 보령시")
                        startActivity(intent)

        }

        buyeobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 부여군")
                        startActivity(intent)

        }

        seosanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 서산시")
                        startActivity(intent)

        }

        seocheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 서천군")
                        startActivity(intent)

        }

        asanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 아산시")
                        startActivity(intent)

        }

        yesanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 예산군")
                        startActivity(intent)

        }

        cheonanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 천안시")
                        startActivity(intent)

        }

        cheongyangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 청양군")
                        startActivity(intent)

        }

        taeanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 태안군")
                        startActivity(intent)

        }

        hongseongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "충남 홍성군")
                        startActivity(intent)

        }

        //
        Gyeongsanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경북 경산시")
                        startActivity(intent)

        }

        Gyeongjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경북 경주시")
                        startActivity(intent)

        }

        Gumibtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경북 구미시")
                        startActivity(intent)

        }

        Gimcheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경북 김천시")
                        startActivity(intent)

        }

        Mungyeongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경북 문경시")
                        startActivity(intent)

        }

        Sangjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경북 상주시")
                        startActivity(intent)

        }

        Andongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경북 안동시")
                        startActivity(intent)

        }

        Yeongjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경북 영주시")
                        startActivity(intent)

        }

        Yeongcheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경북 영천시")
                        startActivity(intent)

        }

        Pohangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경북 포항시")
                        startActivity(intent)

        }

        Geojebtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경남 거제시")
                        startActivity(intent)

        }

        Gimhaebtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경남 김해시")
                        startActivity(intent)

        }

        Miryangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경남 밀양시")
                        startActivity(intent)

        }

        Sacheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경남 사천시")
                        startActivity(intent)

        }

        Yangsanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경남 양산시")
                        startActivity(intent)

        }

        Jinjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경남 진주시")
                        startActivity(intent)

        }

        Changwonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경남 창원시")
                        startActivity(intent)

        }

        Tongyeongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "경남 통영시")
                        startActivity(intent)

        }

        Gunsanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전북 군산시")
                        startActivity(intent)

        }

        Gimjebtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전북 김제시")
                        startActivity(intent)

        }

        Namwonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전북 남원시")
                        startActivity(intent)

        }

        Iksanbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전북 익산시")
                        startActivity(intent)

        }

        Jeonjubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전북 전주시")
                        startActivity(intent)

        }

        Jeongeupbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전북 정읍시")
                        startActivity(intent)

        }

        Gwangyangbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전남 광양시")
                        startActivity(intent)

        }

        Najubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전남 나주시")
                        startActivity(intent)

        }

        Mokpobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전남 목포시")
                        startActivity(intent)

        }

        Suncheonbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전남 순천시")
                        startActivity(intent)

        }

        Yeosubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "전남 여수시")
                        startActivity(intent)

        }
        //
        olsannambtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "울산 남구")
                        startActivity(intent)

        }

        olsandongbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "울산 동구")
                        startActivity(intent)

        }

        olsanbukbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "울산 북구")
                        startActivity(intent)

        }

        Uljubtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "울산 울주군")
                        startActivity(intent)

        }

        olsanjungbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "울산 중구")
                        startActivity(intent)

        }

        Seogwipobtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "제주 서귀포시")
                        startActivity(intent)

        }

        Jejucitybtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "제주 제주시")
                        startActivity(intent)

        }

        sejongallbtn.setOnClickListener {
                        val intent = Intent(this, LocationList::class.java)

            intent.putExtra("location", "세종 전체")
                        startActivity(intent)

        }

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

    }

    private fun showsejong() {
        sejongallbtn.visibility = View.VISIBLE
    }

    private fun hidesejong() {
        sejongallbtn.visibility = View.INVISIBLE
    }

    private fun showjeju() {
        Seogwipobtn.visibility = View.VISIBLE
        Jejucitybtn.visibility = View.VISIBLE
    }

    private fun hidejeju() {
        Seogwipobtn.visibility = View.INVISIBLE
        Jejucitybtn.visibility = View.INVISIBLE
    }

    private fun showulsan() {
        olsannambtn.visibility = View.VISIBLE
        olsandongbtn.visibility = View.VISIBLE
        olsanbukbtn.visibility = View.VISIBLE
        Uljubtn.visibility = View.VISIBLE
        olsanjungbtn.visibility = View.VISIBLE
    }

    private fun hideulsan() {
        olsannambtn.visibility = View.INVISIBLE
        olsandongbtn.visibility = View.INVISIBLE
        olsanbukbtn.visibility = View.INVISIBLE
        Uljubtn.visibility = View.INVISIBLE
        olsanjungbtn.visibility = View.INVISIBLE
    }

    private fun showjeonnam() {
        Gwangyangbtn.visibility = View.VISIBLE
        Najubtn.visibility = View.VISIBLE
        Mokpobtn.visibility = View.VISIBLE
        Suncheonbtn.visibility = View.VISIBLE
        Yeosubtn.visibility = View.VISIBLE
    }

    private fun hidejeonnam() {
        Gwangyangbtn.visibility = View.INVISIBLE
        Najubtn.visibility = View.INVISIBLE
        Mokpobtn.visibility = View.INVISIBLE
        Suncheonbtn.visibility = View.INVISIBLE
        Yeosubtn.visibility = View.INVISIBLE
    }

    private fun showjeonbuk() {
        Gunsanbtn.visibility = View.VISIBLE
        Gimjebtn.visibility = View.VISIBLE
        Namwonbtn.visibility = View.VISIBLE
        Iksanbtn.visibility = View.VISIBLE
        Jeonjubtn.visibility = View.VISIBLE
        Jeongeupbtn.visibility = View.VISIBLE

    }

    private fun hidejeonbuk() {
        Gunsanbtn.visibility = View.INVISIBLE
        Gimjebtn.visibility = View.INVISIBLE
        Namwonbtn.visibility = View.INVISIBLE
        Iksanbtn.visibility = View.INVISIBLE
        Jeonjubtn.visibility = View.INVISIBLE
        Jeongeupbtn.visibility = View.INVISIBLE

    }

    private fun showgyeongnam() {
        Geojebtn.visibility = View.VISIBLE
        Gimhaebtn.visibility = View.VISIBLE
        Miryangbtn.visibility = View.VISIBLE
        Sacheonbtn.visibility = View.VISIBLE
        Yangsanbtn.visibility = View.VISIBLE
        Jinjubtn.visibility = View.VISIBLE
        Changwonbtn.visibility = View.VISIBLE
        Tongyeongbtn.visibility = View.VISIBLE
    }

    private fun hidegyeongnam() {
        Geojebtn.visibility = View.INVISIBLE
        Gimhaebtn.visibility = View.INVISIBLE
        Miryangbtn.visibility = View.INVISIBLE
        Sacheonbtn.visibility = View.INVISIBLE
        Yangsanbtn.visibility = View.INVISIBLE
        Jinjubtn.visibility = View.INVISIBLE
        Changwonbtn.visibility = View.INVISIBLE
        Tongyeongbtn.visibility = View.INVISIBLE
    }

    private fun showgyeongbuk() {
        Gyeongsanbtn.visibility = View.VISIBLE
        Gyeongjubtn.visibility = View.VISIBLE
        Gumibtn.visibility = View.VISIBLE
        Gimcheonbtn.visibility = View.VISIBLE
        Mungyeongbtn.visibility = View.VISIBLE
        Sangjubtn.visibility = View.VISIBLE
        Andongbtn.visibility = View.VISIBLE
        Yeongjubtn.visibility = View.VISIBLE
        Yeongcheonbtn.visibility = View.VISIBLE
        Pohangbtn.visibility = View.VISIBLE
    }

    private fun hidegyeongbuk() {
        Gyeongsanbtn.visibility = View.INVISIBLE
        Gyeongjubtn.visibility = View.INVISIBLE
        Gumibtn.visibility = View.INVISIBLE
        Gimcheonbtn.visibility = View.INVISIBLE
        Mungyeongbtn.visibility = View.INVISIBLE
        Sangjubtn.visibility = View.INVISIBLE
        Andongbtn.visibility = View.INVISIBLE
        Yeongjubtn.visibility = View.INVISIBLE
        Yeongcheonbtn.visibility = View.INVISIBLE
        Pohangbtn.visibility = View.INVISIBLE
    }

    private fun showchungnam() {
        gyeryongbtn.visibility = View.VISIBLE
        gongjubtn.visibility = View.VISIBLE
        geumsanbtn.visibility = View.VISIBLE
        nonsanbtn.visibility = View.VISIBLE
        dangjinbtn.visibility = View.VISIBLE
        boryeongbtn.visibility = View.VISIBLE
        buyeobtn.visibility = View.VISIBLE
        seosanbtn.visibility = View.VISIBLE
        seocheonbtn.visibility = View.VISIBLE
        asanbtn.visibility = View.VISIBLE
        yesanbtn.visibility = View.VISIBLE
        cheonanbtn.visibility = View.VISIBLE
        cheongyangbtn.visibility = View.VISIBLE
        taeanbtn.visibility = View.VISIBLE
        hongseongbtn.visibility = View.VISIBLE
    }

    private fun hidechungnam() {
        gyeryongbtn.visibility = View.INVISIBLE
        gongjubtn.visibility = View.INVISIBLE
        geumsanbtn.visibility = View.INVISIBLE
        nonsanbtn.visibility = View.INVISIBLE
        dangjinbtn.visibility = View.INVISIBLE
        boryeongbtn.visibility = View.INVISIBLE
        buyeobtn.visibility = View.INVISIBLE
        seosanbtn.visibility = View.INVISIBLE
        seocheonbtn.visibility = View.INVISIBLE
        asanbtn.visibility = View.INVISIBLE
        yesanbtn.visibility = View.INVISIBLE
        cheonanbtn.visibility = View.INVISIBLE
        cheongyangbtn.visibility = View.INVISIBLE
        taeanbtn.visibility = View.INVISIBLE
        hongseongbtn.visibility = View.INVISIBLE
    }

    private fun showchunhbuk() {
        goesanbtn.visibility = View.VISIBLE
        danyangbtn.visibility = View.VISIBLE
        boeunbtn.visibility = View.VISIBLE
        yeongdongbtn.visibility = View.VISIBLE
        okcheonbtn.visibility = View.VISIBLE
        eumseongbtn.visibility = View.VISIBLE
        jeungpyeongbtn.visibility = View.VISIBLE
        jincheonbtn.visibility = View.VISIBLE
        jecheonbtn.visibility = View.VISIBLE
        cheongjubtn.visibility = View.VISIBLE
        chungjubtn.visibility = View.VISIBLE
    }

    private fun hidechunhbuk() {
        goesanbtn.visibility = View.INVISIBLE
        danyangbtn.visibility = View.INVISIBLE
        boeunbtn.visibility = View.INVISIBLE
        yeongdongbtn.visibility = View.INVISIBLE
        okcheonbtn.visibility = View.INVISIBLE
        eumseongbtn.visibility = View.INVISIBLE
        jeungpyeongbtn.visibility = View.INVISIBLE
        jincheonbtn.visibility = View.INVISIBLE
        jecheonbtn.visibility = View.INVISIBLE
        cheongjubtn.visibility = View.INVISIBLE
        chungjubtn.visibility = View.INVISIBLE
    }

    private fun showgwangwon() {
        gangneungbtn.visibility = View.VISIBLE
        donghaebtn.visibility = View.VISIBLE
        samcheokbtn.visibility = View.VISIBLE
        sokchobtn.visibility = View.VISIBLE
        wonjubtn.visibility = View.VISIBLE
        chuncheonbtn.visibility = View.VISIBLE
        taebaekbtn.visibility = View.VISIBLE
    }

    private fun hidegwangwon() {
        gangneungbtn.visibility = View.INVISIBLE
        donghaebtn.visibility = View.INVISIBLE
        samcheokbtn.visibility = View.INVISIBLE
        sokchobtn.visibility = View.INVISIBLE
        wonjubtn.visibility = View.INVISIBLE
        chuncheonbtn.visibility = View.INVISIBLE
        taebaekbtn.visibility = View.INVISIBLE
    }

    private fun hidedaegu() {
        gunwibtn.visibility = View.INVISIBLE
        daegunambtn.visibility = View.INVISIBLE
        dalseobtn.visibility = View.INVISIBLE
        dalseongbtn.visibility = View.INVISIBLE
        daehudongbtn.visibility = View.INVISIBLE
        daegubukbtn.visibility = View.INVISIBLE
        daeguseobtn.visibility = View.INVISIBLE
        suseongbtn.visibility = View.INVISIBLE
        daegujungbtn.visibility = View.INVISIBLE
    }

    private fun showdaegu() {
        gunwibtn.visibility = View.VISIBLE
        daegunambtn.visibility = View.VISIBLE
        dalseobtn.visibility = View.VISIBLE
        dalseongbtn.visibility = View.VISIBLE
        daehudongbtn.visibility = View.VISIBLE
        daegubukbtn.visibility = View.VISIBLE
        daeguseobtn.visibility = View.VISIBLE
        suseongbtn.visibility = View.VISIBLE
        daegujungbtn.visibility = View.VISIBLE
    }

    private fun hidedaejeon() {
        daedeokbtn.visibility = View.INVISIBLE
        ddongbtn.visibility = View.INVISIBLE
        dseobtn.visibility = View.INVISIBLE
        yuseongbtn.visibility = View.INVISIBLE
        djungbtn.visibility = View.INVISIBLE
    }

    private fun showdaejeon() {
        daedeokbtn.visibility = View.VISIBLE
        ddongbtn.visibility = View.VISIBLE
        dseobtn.visibility = View.VISIBLE
        yuseongbtn.visibility = View.VISIBLE
        djungbtn.visibility = View.VISIBLE
    }

    private fun hidegwangju() {
        gwangsangubtn.visibility = View.INVISIBLE
        namgubtn.visibility = View.INVISIBLE
        donggubtn.visibility = View.INVISIBLE
        bukgubtn.visibility = View.INVISIBLE
        seogubtn.visibility = View.INVISIBLE
    }

    private fun showgwangju() {
        gwangsangubtn.visibility = View.VISIBLE
        namgubtn.visibility = View.VISIBLE
        donggubtn.visibility = View.VISIBLE
        bukgubtn.visibility = View.VISIBLE
        seogubtn.visibility = View.VISIBLE
    }

    private fun hiedincheon() {
        gyeyangbtn.visibility = View.INVISIBLE
        namdongbtn.visibility = View.INVISIBLE
        idongbtn.visibility = View.INVISIBLE
        michuholbtn.visibility = View.INVISIBLE
        bupyeongbtn.visibility = View.INVISIBLE
        iseobtn.visibility = View.INVISIBLE
        yeonsubtn.visibility = View.INVISIBLE
        ijungbtn.visibility = View.INVISIBLE
        ganghwabtn.visibility = View.INVISIBLE
        ongjinbtn.visibility = View.INVISIBLE
    }

    private fun showincheon() {
        gyeyangbtn.visibility = View.VISIBLE
        namdongbtn.visibility = View.VISIBLE
        idongbtn.visibility = View.VISIBLE
        michuholbtn.visibility = View.VISIBLE
        bupyeongbtn.visibility = View.VISIBLE
        iseobtn.visibility = View.VISIBLE
        yeonsubtn.visibility = View.VISIBLE
        ijungbtn.visibility = View.VISIBLE
        ganghwabtn.visibility = View.VISIBLE
        ongjinbtn.visibility = View.VISIBLE
    }
    private fun hidegyeonggi() {
        deogyanggubtn.visibility = View.INVISIBLE
        ilsandonggubtn.visibility = View.INVISIBLE
        ilsansugubtn.visibility = View.INVISIBLE
        gwacheonbtn.visibility = View.INVISIBLE
        gwangmyeongbtn.visibility = View.INVISIBLE
        gwangjusibtn.visibility = View.INVISIBLE
        guribtn.visibility = View.INVISIBLE
        gunpobtn.visibility = View.INVISIBLE
        gimpobtn.visibility = View.INVISIBLE
        namyangjubtn.visibility = View.INVISIBLE
        dongducheonbtn.visibility = View.INVISIBLE
        bucheonbtn.visibility = View.INVISIBLE
        bundangbtn.visibility = View.INVISIBLE
        sujeongbtn.visibility = View.INVISIBLE
        jungwonbtn.visibility = View.INVISIBLE
        gwonseonbtn.visibility = View.INVISIBLE
        yeongtongbtn.visibility = View.INVISIBLE
        janganbtn.visibility = View.INVISIBLE
        paldalbtn.visibility = View.INVISIBLE
        siheungbtn.visibility = View.INVISIBLE
        danwonbtn.visibility = View.INVISIBLE
        sangnokbtn.visibility = View.INVISIBLE
        anseongbtn.visibility = View.INVISIBLE
        donganbtn.visibility = View.INVISIBLE
        mananbtn.visibility = View.INVISIBLE
        yangjubtn.visibility = View.INVISIBLE
        yeojubtn.visibility = View.INVISIBLE
        osanbtn.visibility = View.INVISIBLE
        giheungbtn.visibility = View.INVISIBLE
        sujibtn.visibility = View.INVISIBLE
        cheoinbtn.visibility = View.INVISIBLE
        uiwangbtn.visibility = View.INVISIBLE
        uijeongbubtn.visibility = View.INVISIBLE
        icheonbtn.visibility = View.INVISIBLE
        pajubtn.visibility = View.INVISIBLE
        pyeongtaekbtn.visibility = View.INVISIBLE
        pocheonbtn.visibility = View.INVISIBLE
        hanambtn.visibility = View.INVISIBLE
        hwaseongbtn.visibility = View.INVISIBLE
    }

    private fun showgyeonggi() {
        deogyanggubtn.visibility = View.VISIBLE
        ilsandonggubtn.visibility = View.VISIBLE
        ilsansugubtn.visibility = View.VISIBLE
        gwacheonbtn.visibility = View.VISIBLE
        gwangmyeongbtn.visibility = View.VISIBLE
        gwangjusibtn.visibility = View.VISIBLE
        guribtn.visibility = View.VISIBLE
        gunpobtn.visibility = View.VISIBLE
        gimpobtn.visibility = View.VISIBLE
        namyangjubtn.visibility = View.VISIBLE
        dongducheonbtn.visibility = View.VISIBLE
        bucheonbtn.visibility = View.VISIBLE
        bundangbtn.visibility = View.VISIBLE
        sujeongbtn.visibility = View.VISIBLE
        jungwonbtn.visibility = View.VISIBLE
        gwonseonbtn.visibility = View.VISIBLE
        yeongtongbtn.visibility = View.VISIBLE
        janganbtn.visibility = View.VISIBLE
        paldalbtn.visibility = View.VISIBLE
        siheungbtn.visibility = View.VISIBLE
        danwonbtn.visibility = View.VISIBLE
        sangnokbtn.visibility = View.VISIBLE
        anseongbtn.visibility = View.VISIBLE
        donganbtn.visibility = View.VISIBLE
        mananbtn.visibility = View.VISIBLE
        yangjubtn.visibility = View.VISIBLE
        yeojubtn.visibility = View.VISIBLE
        osanbtn.visibility = View.VISIBLE
        giheungbtn.visibility = View.VISIBLE
        sujibtn.visibility = View.VISIBLE
        cheoinbtn.visibility = View.VISIBLE
        uiwangbtn.visibility = View.VISIBLE
        uijeongbubtn.visibility = View.VISIBLE
        icheonbtn.visibility = View.VISIBLE
        pajubtn.visibility = View.VISIBLE
        pyeongtaekbtn.visibility = View.VISIBLE
        pocheonbtn.visibility = View.VISIBLE
        hanambtn.visibility = View.VISIBLE
        hwaseongbtn.visibility = View.VISIBLE
    }

    private fun hideseoul() {
        gangnambtn.visibility = View.INVISIBLE
        gangdongbtn.visibility = View.INVISIBLE
        gangbukbtn.visibility = View.INVISIBLE
        gangsubtn.visibility = View.INVISIBLE
        gangakbtn.visibility = View.INVISIBLE
        gangjinbtn.visibility = View.INVISIBLE
        gurobtn.visibility = View.INVISIBLE
        geumcheonbtn.visibility = View.INVISIBLE
        nowonbtn.visibility = View.INVISIBLE
        dobongbtn.visibility = View.INVISIBLE
        dongdaemunbtn.visibility = View.INVISIBLE
        dongjakbtn.visibility = View.INVISIBLE
        mapobtn.visibility = View.INVISIBLE
        seodaemunbtn.visibility = View.INVISIBLE
        seochobtn.visibility = View.INVISIBLE
        seongdongbtn.visibility = View.INVISIBLE
        seongbukbtn.visibility = View.INVISIBLE
        songpabtn.visibility = View.INVISIBLE
        yangcheonbtn.visibility = View.INVISIBLE
        yeongdeungpobtn.visibility = View.INVISIBLE
        yongsanbtn.visibility = View.INVISIBLE
        eunpyeongbtn.visibility = View.INVISIBLE
        jongnobtn.visibility = View.INVISIBLE
        jungbtn.visibility = View.INVISIBLE
        jungnangbtn.visibility = View.INVISIBLE
    }

    private fun showseoul() {
        gangnambtn.visibility = View.VISIBLE
        gangdongbtn.visibility = View.VISIBLE
        gangbukbtn.visibility = View.VISIBLE
        gangsubtn.visibility = View.VISIBLE
        gangakbtn.visibility = View.VISIBLE
        gangjinbtn.visibility = View.VISIBLE
        gurobtn.visibility = View.VISIBLE
        geumcheonbtn.visibility = View.VISIBLE
        nowonbtn.visibility = View.VISIBLE
        dobongbtn.visibility = View.VISIBLE
        dongdaemunbtn.visibility = View.VISIBLE
        dongjakbtn.visibility = View.VISIBLE
        mapobtn.visibility = View.VISIBLE
        seodaemunbtn.visibility = View.VISIBLE
        seochobtn.visibility = View.VISIBLE
        seongdongbtn.visibility = View.VISIBLE
        seongbukbtn.visibility = View.VISIBLE
        songpabtn.visibility = View.VISIBLE
        yangcheonbtn.visibility = View.VISIBLE
        yeongdeungpobtn.visibility = View.VISIBLE
        yongsanbtn.visibility = View.VISIBLE
        eunpyeongbtn.visibility = View.VISIBLE
        jongnobtn.visibility = View.VISIBLE
        jungbtn.visibility = View.VISIBLE
        jungnangbtn.visibility = View.VISIBLE
    }

    private fun hidebusan() {
        gangseobtn.visibility = View.INVISIBLE
        geumjeongbtn.visibility = View.INVISIBLE
        gijangbtn.visibility = View.INVISIBLE
        bnambtn.visibility = View.INVISIBLE
        bdongbtn.visibility = View.INVISIBLE
        dongnaebtn.visibility = View.INVISIBLE
        busanjinbtn.visibility = View.INVISIBLE
        bbukbtn.visibility = View.INVISIBLE
        sasangbtn.visibility = View.INVISIBLE
        sahabtn.visibility = View.INVISIBLE
        bseobtn.visibility = View.INVISIBLE
        suyeongbtn.visibility = View.INVISIBLE
        yeonjebtn.visibility = View.INVISIBLE
        yeongdobtn.visibility = View.INVISIBLE
        bzongbtn.visibility = View.INVISIBLE
        haeundaebtn.visibility = View.INVISIBLE    }

    private fun showbusan() {
        gangseobtn.visibility = View.VISIBLE
        geumjeongbtn.visibility = View.VISIBLE
        gijangbtn.visibility = View.VISIBLE
        bnambtn.visibility = View.VISIBLE
        bdongbtn.visibility = View.VISIBLE
        dongnaebtn.visibility = View.VISIBLE
        busanjinbtn.visibility = View.VISIBLE
        bbukbtn.visibility = View.VISIBLE
        sasangbtn.visibility = View.VISIBLE
        sahabtn.visibility = View.VISIBLE
        bseobtn.visibility = View.VISIBLE
        suyeongbtn.visibility = View.VISIBLE
        yeonjebtn.visibility = View.VISIBLE
        yeongdobtn.visibility = View.VISIBLE
        bzongbtn.visibility = View.VISIBLE
        haeundaebtn.visibility = View.VISIBLE    }
}