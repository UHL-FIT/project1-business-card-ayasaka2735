package com.example.danhthiepcuakhanhminhbui
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.danhthiepcuakhanhminhbui.ui.theme.DanhThiepCuaKhanhMinhBuiTheme

//Thiết bị : Samsung S9 Edge
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DanhThiepCuaKhanhMinhBuiTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GiaoDienDanhThiep()
                }
            }
        }
    }
}

@Composable
fun GiaoDienDanhThiep() {
    //Cột tổng (Toàn màn hình)
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFA1887F)), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {
        //Phần thông tin cá nhân (Cột thứ nhất)
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {
            val AnhDaiDien = painterResource(R.drawable.anh_dai_dien)
            Image(painter = AnhDaiDien, contentDescription = "Ảnh đại diện", modifier = Modifier.size(200.dp))
            Text(text = "Bùi Khánh Minh", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3E2723), modifier = Modifier.padding(top = 22.dp, bottom = 8.dp))
            Text(text = "Lớp CNTT K1C - Trường Đại Học Hạ Long", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3E2723))
        }

        //Spacer dùng để tạo 1 khoảng trống giữa 2 cột để tách 2 cột ra không dính vào nhau, spacer không chứa gì bên trong
        Spacer(modifier = Modifier.height(30.dp))

        //Phần thông tin liên hệ (Cột thứ hai)
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
        {
            PhanLienHe(AnhPhanLienHe = R.drawable.anh_dien_thoai, ThongTinPhanLienHe = "0358112883", MauChu = Color(0xFF3E2723))
            PhanLienHe(AnhPhanLienHe = R.drawable.anh_facebook, ThongTinPhanLienHe = "Khanh Minh Bui", MauChu = Color(0xFF3E2723))
            PhanLienHe(AnhPhanLienHe = R.drawable.anh_gmail, ThongTinPhanLienHe = "minhanh270305@gmail.com", MauChu = Color(0xFF3E2723))
        }
    }
}

@Composable
//Hàng ngang (Row) cho phần thông tin liên hệ (Cột thứ hai) để đỡ phải lặp lại nhiều lần row ở trong phần liên hệ khiến nó dài dòng. Tạo khung UI(FE) để tí ném dữ liệu vào là được
fun PhanLienHe(AnhPhanLienHe: Int, ThongTinPhanLienHe: String, MauChu: Color)
{
    Row(modifier = Modifier.fillMaxWidth().padding(start = 50.dp, end = 50.dp, top = 12.dp, bottom = 5.dp), verticalAlignment = Alignment.CenterVertically)
    {
        Image(painter = painterResource(AnhPhanLienHe), contentDescription = null, modifier = Modifier.size(36.dp).padding(end = 6.dp))
        Text(text = ThongTinPhanLienHe, fontSize = 18.sp, fontWeight = FontWeight.Medium, color = MauChu)
    }
}

@Preview(showBackground = true)
@Composable
fun XemTruocDanhThiep() {
    DanhThiepCuaKhanhMinhBuiTheme {
        Surface(modifier = Modifier.fillMaxSize())
        {
            GiaoDienDanhThiep()
        }
    }
}