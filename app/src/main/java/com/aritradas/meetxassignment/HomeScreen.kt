package com.aritradas.meetxassignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aritradas.meetxassignment.ui.theme.MeetXAssignmentTheme

@Composable
fun HomeScreen() {

    Scaffold(
        topBar = { HomeTopAppBar() },
        bottomBar = { HomeBottomNavBar() },
        containerColor = Color.White,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .background(Color.White)
        ) {

            val activeColor = Color(0xFF7346E2)
            val chipModifier = Modifier
                .padding(horizontal = 4.dp)
                .height(36.dp)
                .clip(RoundedCornerShape(18.dp))


            // Passion & Pursuits Chips
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F6FA))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        8.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Passion & Pursuits",
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 18.dp, top = 10.dp, bottom = 6.dp)
                    )

                    HorizontalDivider(
                        modifier = Modifier.width(208.dp),
                        thickness = 1.dp
                    )
                }

                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp)
                ) {
                    // Replace with your own Icon and data list
                    listOf(
                        R.drawable.all to "All",
                        R.drawable.basketball to "Basketball",
                        R.drawable.bmx to "BMX",
                        R.drawable.debate to "Debate",
                        R.drawable.critical to "Critical..",
                        R.drawable.community to "Community",
                        R.drawable.blood_donation to "Blood Dona.."
                    ).forEach { (res, label) ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = res),
                                contentDescription = label,
                                modifier = Modifier.size(32.dp)
                            )

                            Text(
                                text = label,
                                fontSize = 10.sp,
                                color = Color(0xFF877BBA),
                                fontWeight = if (label == "All") FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            // Live & Trending Filter
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFEDF6FF))
                    .padding(vertical = 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        8.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Live & Trending Near You",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 18.dp)
                    )

                    HorizontalDivider(
                        modifier = Modifier.width(208.dp),
                        thickness = 1.dp
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .border(
                            width = 0.5.dp,
                            color = Color(0xFF4B4544),
                            shape = RoundedCornerShape(24.dp)
                        )
                        .clip(RoundedCornerShape(24.dp))
                        .background(Color.White)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        12.dp,
                        Alignment.CenterHorizontally
                    )
                ) {

                    Text(
                        "All",
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = chipModifier
                            .background(activeColor)
                            .padding(horizontal = 18.dp, vertical = 6.dp)
                    )
                    Text(
                        "Planned Activity",
                        color = activeColor,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = chipModifier
                            .padding(horizontal = 14.dp, vertical = 6.dp)
                    )
                    Text(
                        "Live Activity",
                        color = Color(0xFF38C588),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = chipModifier
                            .padding(horizontal = 14.dp, vertical = 6.dp)
                    )
                }
            }


            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        modifier = Modifier
                            .size(46.dp)
                            .border(
                                width = 2.dp,
                                color = Color(0xFF6F13F5),
                                shape = RoundedCornerShape(24.dp)
                            ),
                        painter = painterResource(R.drawable.person_1),
                        contentDescription = "Person Image"
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Image(
                                modifier = Modifier.size(8.dp),
                                painter = painterResource(R.drawable.online_icon),
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            Text("Jemmy Ray", fontWeight = FontWeight.Bold, fontSize = 15.sp)

                        }

                        Text(
                            "2 hour ago",
                            fontSize = 11.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 6.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(Color(0xFF9545FF), Color(0xFFE9429E))
                                ),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(horizontal = 14.dp, vertical = 6.dp)
                    ) {
                        Text(
                            "Interest \n Requested",
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        16.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.location),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )

                    Text(
                        "Chilling at Summer House Café Lorem Ipsum has been the industry's standard..",
                        color = Color.Gray, fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.calendar),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )

                    Text(
                        "Saturday, October 21 at 7:00 PM",
                        fontSize = 12.sp, color = Color(0xFF877BBA),
                        modifier = Modifier.padding(start = 4.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        painter = painterResource(R.drawable.community_icon),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )

                    Text(
                        "16 Joined",
                        fontSize = 12.sp,
                        color = Color(0xFF877BBA),
                        modifier = Modifier.padding(start = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            FeaturedActivityCard()
        }
    }
}

@Composable
fun HomeTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.Place, contentDescription = null, tint = Color(0xFF9646E3))
        Text(
            text = "Prestige Lakeside Habitat Habitat.....",
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Icon(
            Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF9646E3)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Icon(
            Icons.Default.Notifications,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF9646E3)
        )
    }
}

@Composable
fun HomeBottomNavBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(22.dp)
            )
    ) {
        Row(
            Modifier
                .padding(horizontal = 22.dp)
                .height(52.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                Icons.Default.Home,
                contentDescription = null,
                tint = Color(0xFFA79BC7),
                modifier = Modifier.size(28.dp)
            )
            Icon(
                Icons.Default.MailOutline,
                contentDescription = null,
                tint = Color(0xFFA79BC7),
                modifier = Modifier.size(28.dp)
            )
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color(0xFF974FE6), CircleShape)
                    .border(4.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
            Icon(
                Icons.Default.MailOutline,
                contentDescription = null,
                tint = Color(0xFFA79BC7),
                modifier = Modifier.size(28.dp)
            )
            Icon(
                Icons.Default.Favorite,
                contentDescription = null,
                tint = Color(0xFFA79BC7),
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun FeaturedActivityCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .aspectRatio(1.1f)
            .clip(RoundedCornerShape(18.dp))
    ) {
        // Main Image
        Image(
            painter = painterResource(id = R.drawable.post_image),
            contentDescription = "Featured Activity",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Top Overlay with profile and text
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .align(Alignment.TopStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.person_2),
                contentDescription = "Emma Lily",
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color.White, CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text("Emma Lily", color = Color.White, fontWeight = FontWeight.Bold)
                Text("9 min ago", color = Color.White, fontWeight = FontWeight.Normal)
            }
        }

        // Bottom overlay (Gradient, content, icons)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color(0xC2000000)),
                        startY = 0f, endY = 320f
                    ),
                    shape = RoundedCornerShape(bottomStart = 18.dp, bottomEnd = 18.dp)
                )
                .padding(8.dp)
        ) {
            // Info Row with avatar, name, date/time, close
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFF4D2685), Color(0xFF9741C6).copy(alpha = 0.9f))
                        ),
                        shape = RoundedCornerShape(24.dp)
                    )
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.person_3), // small profile image
                    contentDescription = "Mera Joseph",
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.White, CircleShape)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Mera Joseph", color = Color.White)
                Spacer(modifier = Modifier.width(12.dp))
                Text("Jan 14 2024 | 10:30", color = Color.White, fontSize = androidx.compose.ui.unit.TextUnit.Unspecified)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.Close,
                    tint = Color.White,
                    contentDescription = "Close",
                    modifier = Modifier.size(18.dp)
                )
            }

            // Subtitle Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.location), // location icon
                    contentDescription = "Location",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    "Chilling at Summer House Café Lorem...",
                    color = Color.White,
                    fontSize = androidx.compose.ui.unit.TextUnit.Unspecified
                )
            }
            // Main text
            Text(
                "Today, I experienced the most amazing music and The air feels amazing... more",
                color = Color.White,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Bottom Row: icons for like, comment, views, more
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(R.drawable.love_icon),
                    contentDescription = "Like",
                    tint = Color.White,
                    modifier = Modifier.size(15.dp)
                )

                Spacer(Modifier.width(4.dp))
                Text("7", color = Color.White)
                Spacer(Modifier.width(14.dp))
                Icon(
                    painter = painterResource(R.drawable.comment_icon), // comment icon
                    contentDescription = "Comment",
                    tint = Color.White,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text("2", color = Color.White)
                Spacer(Modifier.width(14.dp))
                Icon(
                    painter = painterResource(R.drawable.send_icon), // eye/views icon
                    contentDescription = "Views",
                    tint = Color.White,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text("12", color = Color.White)
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MeetXAssignmentTheme {
        HomeScreen()
    }
}
