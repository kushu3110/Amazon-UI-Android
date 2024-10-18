package com.example.amazonui

import android.service.autofill.OnClickAction
import androidx.activity.compose.ReportDrawn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amazonui.ui.theme.amznAddress
import com.example.amazonui.ui.theme.amznOrange
import com.example.amazonui.ui.theme.amznYellow
import com.example.amazonui.ui.theme.greyyy

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val stat = rememberScrollState()
    val menus = listOf(
        navbar(
            imgResource = R.drawable.amzn_home,
            title = "Home"
        ),
        navbar(
            imgResource = R.drawable.amzn_profile,
            title = "You"
        ),
        navbar(
            imgResource = R.drawable.amzn_more,
            title = "More"
        ),
        navbar(
            imgResource =R.drawable.amzn_cart ,
            title = "Cart"
        ),
        navbar(
            imgResource = R.drawable.amzn_menu,
            title = "Menu"
        )
    )
    val categoryMenu = listOf(
        CategoryRow(
            categoryTitle = "Prime",
            categoryImage = R.drawable.cat_prime
        ),
        CategoryRow(
            categoryTitle = "Laptops",
            categoryImage = R.drawable.cat_laptop
        ),
        CategoryRow(
            categoryTitle = "Home",
            categoryImage = R.drawable.cat_chair
        ),
        CategoryRow(
            categoryTitle = "Appliances",
            categoryImage = R.drawable.cap_fridge
        ),
        CategoryRow(
            categoryTitle = "Kitchen",
            categoryImage = R.drawable.cat_mixer
        ),
        CategoryRow(
            categoryTitle = "Electronics",
            categoryImage = R.drawable.cat_electronics
        ),
        CategoryRow(
            categoryTitle = "Fashion",
            categoryImage = R.drawable.cat_fashion
        )
    )
    val advetismentList = listOf(
        Advertisement(
            imageId = R.drawable.advertisement_1
        ),
        Advertisement(
            imageId = R.drawable.advertisement_2
        ),
        Advertisement(
            imageId = R.drawable.advertisement_3
        )
    )
    val bigAdvertisementList = listOf(
        BigAdvertisement(
            title = "Prime exclusive cashback",
            image = R.drawable.big_prime
        ),
        BigAdvertisement(
            title = "Spin & Win",
            image = R.drawable.big_spin
        ),
        BigAdvertisement(
            title = "Amazon Coupons",
            image = R.drawable.big_corporate
        ),
        BigAdvertisement(
            title = "Corporate Gifting",
            image = R.drawable.big_credit
        ),
        BigAdvertisement(
            title = "Credit for you",
            image = R.drawable.big_large
        ),
        BigAdvertisement(
            title = "Deals on Large Appliances",
            image = R.drawable.big_coupon
        ),
        BigAdvertisement(
            title = "Apple Macbook Air",
            image = R.drawable.big_mac
        )
    )
    val gridAd = listOf(
        gridItem(
            image = R.drawable.grid_mac,
            mrp = "92,990",
            rate = "59,990",
            name = "MacBook Air M1"
        ),
        gridItem(
            image = R.drawable.grid_bag,
            mrp = "560",
            rate = "278",
            name = "Dyazo Laptop Bag"
        ),
        gridItem(
            image = R.drawable.grid_boult,
            mrp = "3900",
            rate = "1098",
            name = "Boult Z40 Low Lat..."
        ),
        gridItem(
            image = R.drawable.grid_guitar,
            mrp = "350",
            rate = "120",
            name = "Juarez Guitar Clip"
        )
    )
    TopSearchBar()
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 80.dp)
        .background(Color.Gray)
    ){
        Column(modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = stat)
        ){
            AddressLine()
            CatagoriesSection(category = categoryMenu)
            AdvertisementSection(items = advetismentList)
            BidAdvertidement(advertise = bigAdvertisementList)
            GridSection(items = gridAd)
        }
    }
    BottomNavBar(items = menus)

}

@Composable
fun TopSearchBar(modifier:Modifier = Modifier) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                Brush.horizontalGradient(
                    listOf(amznOrange, amznYellow)
                )
            )
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 50.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Box (
                modifier = Modifier
                    .height(40.dp)
                    .width(340.dp)
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(vertical = 10.dp, horizontal = 10.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                   Icon(
                       painter = painterResource(R.drawable.amzn_search),
                       contentDescription = "search",
                       Modifier.size(25.dp)
                   )
                   Text(
                       text = "Search or ask a question",
                       color = Color.LightGray,
                       fontSize = 15.sp
                   )
                   Icon(
                       painter = painterResource(R.drawable.amzn_camscan),
                       contentDescription = "camscan",
                       Modifier.size(25.dp),
                       tint = Color.Gray
                   )
                    Icon(
                       painter = painterResource(R.drawable.amzn_mic),
                       contentDescription = "mic",
                       Modifier.size(25.dp),
                       tint = Color.Gray
                   )
                }
            }
            Image(
                painter = painterResource(R.drawable.amzn_qr),
                contentDescription = "QR",
                Modifier.size(30.dp)
            )


        }
    }
}

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    items: List<navbar>) {
    var isSelectedstate by remember {
        mutableStateOf(0)
    }
    Box(modifier = Modifier.fillMaxSize()){
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(80.dp)
                .border(1.dp, Color.Gray)
                .align(Alignment.BottomCenter)
                .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
        ){
            Row (
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                items.forEachIndexed{ index, items ->
                    MenuShape(
                        item = items,
                        isSelected = index == isSelectedstate,
                        onClickAction = {
                            isSelectedstate = index
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MenuShape(
    item: navbar,
    isSelected: Boolean,
    onClickAction: ()->Unit,
    inactivecolor: Color = Color.Black,
    activecolor: Color = amznOrange
) {
        Column (
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable {
                onClickAction()
            }
        ) {
            Icon(
                painter = painterResource(item.imgResource),
                contentDescription = item.title,
                tint = if (isSelected) activecolor else inactivecolor,
                modifier = Modifier.size(
                    if(isSelected) 30.dp
                    else 20.dp
                ),
            )
            Text(
                text = item.title,
                color = if (isSelected) activecolor else inactivecolor,
                fontWeight = if(isSelected) FontWeight.ExtraBold else FontWeight.Normal

            )
        }


}

@Composable
fun AddressLine(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .height(35.dp)
            .background(amznAddress)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 7.5.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.amzn_loation),
                contentDescription = "Address"
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Deliver to M/S - Greater Noida 201310 "
            )
        }
    }
}

@Composable
fun CatagoriesSection(
    modifier: Modifier = Modifier,
    category : List<CategoryRow>
) {
    Box (modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(vertical = 2.dp)
        .background(Color.White)
    ) {
        LazyRow (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            items(count = category.size){ index ->
                val categ = category[index]
                CategoryItems(modifier,categ)
            }

        }

    }

}

@Composable
fun CategoryItems(
    modifier:Modifier,
    item : CategoryRow
) {
    Column (
        modifier = Modifier
            .height(80.dp)
            .width(80.dp)
            .padding(top = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box (modifier = Modifier
            .border(2.dp, amznYellow, shape = CircleShape)
            .background(Color.White, shape = CircleShape)
        ) {
            Image(
                painter = painterResource(item.categoryImage),
                contentDescription = item.categoryTitle,
                modifier = Modifier.size(50.dp)
            )
        }

        Text(text = item.categoryTitle, fontWeight = FontWeight.Normal)

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AdvertisementSection(
    modifier: Modifier = Modifier,
    items: List<Advertisement>
) {
    val listState = rememberLazyListState()
    val snapperFlingBehaviour= rememberSnapFlingBehavior(listState)
   Box(
       modifier = Modifier
           .fillMaxWidth()
           .height(150.dp)
           .padding(bottom = 2.dp)
   ) {
       LazyRow (
           state = listState,
           flingBehavior = snapperFlingBehaviour
       ) {
           items(count = items.size){
               Image(
                   painter = painterResource(items[it].imageId),
                   contentDescription = "null"
               )
           }
       }
   }

}

@Composable
fun BidAdvertidement(
    modifier: Modifier = Modifier,
    advertise: List<BigAdvertisement>
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .background(Color.White)
            .padding(top = 8.dp, bottom = 2.dp)

    ) {
        LazyRow (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
           items(count = advertise.size){ index ->
               val adv = advertise[index]
               BigAdvertisementInsider(item = adv)
           }
        }
    }
}

@Composable
fun BigAdvertisementInsider(
    modifier: Modifier = Modifier,
    item: BigAdvertisement
) {
    Box (
        modifier = Modifier
            .height(150.dp)
            .width(135.dp)
            .padding(start = 10.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .shadow(elevation = 1.dp)
                .padding(5.dp)
        ) {
            Text(
                text = item.title,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(item.image),
                contentDescription = item.title
            )
        }
    }
}

@Composable
fun GridSection(
    modifier: Modifier = Modifier,
    items: List<gridItem>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 2.dp)
            .background(Color.White)
            .padding(10.dp)
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start
            ) {
            Text(
                "Pick up where you left off",
                fontSize = 24.sp,
                fontWeight = FontWeight.Thin
            )
            Column (
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GridItem(item= items, index = 0)
                    GridItem(item= items, index = 1)
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GridItem(item= items, index = 2)
                    GridItem(item= items, index = 3)
                }

            }
            Text(
                text = "See more",
                fontSize = 18.sp,
                fontWeight = FontWeight.Thin,
                color = Color.Blue
            )
        }
    }
}

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    item: List<gridItem>,
    index: Int
) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .width(200.dp)
            .background(greyyy)
            .padding(5.dp)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ,modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(item[index].image),
                contentDescription = item[index].name,
                modifier = Modifier
                    .size(150.dp)
                    .aspectRatio(1f)
            )
            Text(
                text = item[index].name,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraLight
            )
            Text(
                text = "₹${item[index].rate}",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraLight
            )
            Text(
                text = "M.R.P: ₹${item[index].mrp}",
                textDecoration = TextDecoration.LineThrough,
                fontWeight = FontWeight.ExtraLight
            )
        }
    }
}















































