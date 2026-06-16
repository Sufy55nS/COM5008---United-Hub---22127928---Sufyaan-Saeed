package com.example.unitedhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

val UnitedRed = Color(0xFFDA291C)
val UnitedGold = Color(0xFFF2C94C)
val UnitedBlack = Color(0xFF111111)
val UnitedBackground = Color(0xFFF5F5F5)
val UnitedCard = Color(0xFFFFFFFF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = UnitedRed,
                    secondary = UnitedGold,
                    background = UnitedBackground,
                    surface = UnitedCard,
                    onPrimary = Color.White,
                    onSecondary = UnitedBlack,
                    onBackground = UnitedBlack,
                    onSurface = UnitedBlack
                )
            ) {
                UnitedHubApp()
            }
        }
    }
}

@Composable
fun UnitedHubApp() {
    var selectedScreen by remember { mutableStateOf("Home") }

    Scaffold(
        containerColor = UnitedBackground,
        bottomBar = {
            NavigationBar(
                containerColor = UnitedBlack
            ) {
                NavItem("Home", selectedScreen) { selectedScreen = "Home" }
                NavItem("Fixtures", selectedScreen) { selectedScreen = "Fixtures" }
                NavItem("Squad", selectedScreen) { selectedScreen = "Squad" }
                NavItem("News", selectedScreen) { selectedScreen = "News" }
                NavItem("Fav", selectedScreen) { selectedScreen = "Fav" }
                NavItem("History", selectedScreen) { selectedScreen = "History" }
                NavItem("Cups", selectedScreen) { selectedScreen = "Cups" }
                NavItem("Stats", selectedScreen) { selectedScreen = "Stats" }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(UnitedBackground)
                .padding(paddingValues)
        ) {
            when (selectedScreen) {
                "Home" -> HomeScreen()
                "Fixtures" -> FixturesScreen()
                "Squad" -> SquadScreen()
                "News" -> NewsScreen()
                "Fav" -> FavouriteScreen()
                "History" -> HistoryScreen()
                "Cups" -> TrophiesScreen()
                "Stats" -> StatsScreen()
            }
        }
    }
}

@Composable
fun NavItem(
    label: String,
    selectedScreen: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.padding(horizontal = 2.dp),
        colors = ButtonDefaults.textButtonColors(
            contentColor = if (selectedScreen == label) UnitedGold else Color.White
        )
    ) {
        Text(
            text = label,
            fontWeight = if (selectedScreen == label) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = UnitedRed),
            border = BorderStroke(2.dp, UnitedGold)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.manutd_logo),
                    contentDescription = "Manchester United Logo",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "UnitedHub",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Manchester United Fan Hub",
                    style = MaterialTheme.typography.titleMedium,
                    color = UnitedGold
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        InfoCard(
            title = "Next Match",
            body = "Manchester United vs Liverpool\n17 June 2026\nOld Trafford"
        )

        InfoCard(
            title = "Welcome Red Devils!",
            body = "A fan companion app for fixtures, squad information, club news, history and favourite players."
        )

        InfoCard(
            title = "App Purpose",
            body = "UnitedHub is designed for Manchester United fans who want quick access to fixtures, squad details, club news, history, trophies and a favourite player feature."
        )

        InfoCard(
            title = "Target Users",
            body = "The target users are football fans, especially Manchester United supporters aged 13 and above."
        )

        InfoCard(
            title = "Security and Privacy",
            body = "This prototype does not require login details and does not collect sensitive personal information."
        )
    }
}

@Composable
fun FixturesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ScreenTitle("Upcoming Fixtures")

        InfoCard(
            title = "Manchester United vs Liverpool",
            body = "Premier League\n17 June 2026\nOld Trafford"
        )

        InfoCard(
            title = "Chelsea vs Manchester United",
            body = "Premier League\n24 June 2026\nStamford Bridge"
        )

        InfoCard(
            title = "Manchester United vs Arsenal",
            body = "Premier League\n1 July 2026\nOld Trafford"
        )
    }
}

@Composable
fun SquadScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        ScreenTitle("Manchester United Squad")

        PlayerCard("Altay Bayindir", "Goalkeeper", "1")
        PlayerCard("Tom Heaton", "Goalkeeper", "22")
        PlayerCard("Senne Lammens", "Goalkeeper", "31")

        PlayerCard("Diogo Dalot", "Defender", "2")
        PlayerCard("Noussair Mazraoui", "Defender", "3")
        PlayerCard("Matthijs de Ligt", "Defender", "4")
        PlayerCard("Harry Maguire", "Defender", "5")
        PlayerCard("Lisandro Martínez", "Defender", "6")
        PlayerCard("Patrick Dorgu", "Defender", "13")
        PlayerCard("Leny Yoro", "Defender", "15")
        PlayerCard("Luke Shaw", "Defender", "23")

        PlayerCard("Mason Mount", "Midfielder", "7")
        PlayerCard("Bruno Fernandes", "Midfielder", "8")
        PlayerCard("Casemiro", "Midfielder", "18")
        PlayerCard("Manuel Ugarte", "Midfielder", "25")
        PlayerCard("Kobbie Mainoo", "Midfielder", "37")

        PlayerCard("Matheus Cunha", "Forward", "10")
        PlayerCard("Joshua Zirkzee", "Forward", "11")
        PlayerCard("Amad", "Forward", "16")
        PlayerCard("Bryan Mbeumo", "Forward", "19")
        PlayerCard("Benjamin Šeško", "Forward", "30")
    }
}

@Composable
fun PlayerCard(
    name: String,
    position: String,
    number: String
) {
    InfoCard(
        title = name,
        body = "Position: $position\nNumber: $number"
    )
}

@Composable
fun NewsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ScreenTitle("Manchester United News")

        InfoCard(
            title = "Match Preview",
            body = "United prepare for their next Premier League fixture."
        )

        InfoCard(
            title = "Squad Update",
            body = "The manager gives an update before the next match."
        )

        InfoCard(
            title = "Old Trafford News",
            body = "Supporters continue to follow stadium development updates."
        )
    }
}

@Composable
fun FavouriteScreen() {
    var favouritePlayer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        ScreenTitle("Favourite Player")

        FavouriteButton("Bruno Fernandes") { favouritePlayer = it }
        FavouriteButton("Kobbie Mainoo") { favouritePlayer = it }
        FavouriteButton("Amad") { favouritePlayer = it }
        FavouriteButton("Leny Yoro") { favouritePlayer = it }
        FavouriteButton("Matthijs de Ligt") { favouritePlayer = it }
        FavouriteButton("Joshua Zirkzee") { favouritePlayer = it }
        FavouriteButton("Mason Mount") { favouritePlayer = it }
        FavouriteButton("Luke Shaw") { favouritePlayer = it }

        Spacer(modifier = Modifier.height(20.dp))

        if (favouritePlayer.isNotEmpty()) {
            InfoCard(
                title = "Saved Favourite",
                body = "Your favourite player is: $favouritePlayer"
            )
        }
    }
}

@Composable
fun FavouriteButton(
    playerName: String,
    onSelected: (String) -> Unit
) {
    Button(
        onClick = { onSelected(playerName) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = UnitedRed,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(14.dp)
    ) {
        Text("Choose $playerName")
    }
}

@Composable
fun HistoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        ScreenTitle("Club History")

        InfoCard(
            title = "Manchester United History",
            body = "Manchester United was founded in 1878 as Newton Heath LYR Football Club. The club became Manchester United in 1902."
        )

        InfoCard(
            title = "Old Trafford",
            body = "Old Trafford has been Manchester United's home stadium since 1910 and is known as the Theatre of Dreams."
        )
    }
}

@Composable
fun TrophiesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ScreenTitle("Trophy Cabinet")

        InfoCard(
            title = "Premier League / First Division",
            body = "20 league titles"
        )

        InfoCard(
            title = "FA Cup",
            body = "Multiple FA Cup wins"
        )

        InfoCard(
            title = "UEFA Champions League",
            body = "European champions"
        )

        InfoCard(
            title = "League Cup",
            body = "Domestic cup success"
        )
    }
}

@Composable
fun StatsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        ScreenTitle("Player Statistics")

        InfoCard(
            title = "Bruno Fernandes",
            body = "Position: Midfielder\nAppearances: 35\nGoals: 10\nAssists: 12"
        )

        InfoCard(
            title = "Kobbie Mainoo",
            body = "Position: Midfielder\nAppearances: 28\nGoals: 4\nAssists: 5"
        )

        InfoCard(
            title = "Amad",
            body = "Position: Forward\nAppearances: 30\nGoals: 8\nAssists: 6"
        )

        InfoCard(
            title = "Leny Yoro",
            body = "Position: Defender\nAppearances: 24\nGoals: 1\nClean Sheets: 9"
        )
    }
}

@Composable
fun ScreenTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall,
        color = UnitedRed,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun InfoCard(
    title: String,
    body: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = UnitedCard),
        border = BorderStroke(1.dp, UnitedRed.copy(alpha = 0.25f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = UnitedRed,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = body,
                color = UnitedBlack
            )
        }
    }
}