## DEVELOPMENT API KEY THIS APP USES

## XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

## APP RATE LIMIT:

## Base Tier:  10 Requests Per Minute

from pubg_python import PUBG, Shard
import MySQLdb
from openpyxl import Workbook

KEY = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"

con = MySQLdb.connect(host="xxxx", port=xxxx, user='xxxx', passwd='xxx', db='xxx')

cursor = con.cursor()
cursor.execute('SELECT nick_pubg FROM jogador')

jogadores = cursor.fetchall()
jogadores = [jogador[0] for jogador in jogadores]
api = PUBG(KEY, Shard.PC_SA)

wb = Workbook(write_only=True)
ws = wb.create_sheet()

ws.append(["Nome", "Mapa", "Modo de Jogo", "Data", "Kills", "Posição Final"])

jogadoresSeparados = []
posFinalConjunto5Array1 = 0
cont = 1
while cont<=(len(jogadores)/5):
    jogs = []
    i=(cont*5)-5
    while i<5*cont:
        jogs.append(jogadores[i])
        i+=1
        if len(jogadores)-i<5:
            posFinalConjunto5Array1 = i
    jogadoresSeparados.append(jogs)
    cont+=1
jogs = []
while posFinalConjunto5Array1 < len(jogadores):
    jogs = jogadores [posFinalConjunto5Array1]
    posFinalConjunto5Array1+=1

playersColetados = 0

for jogadores in jogadoresSeparados:
    try:
        players = api.players().filter(player_names=jogadores)
        for player in players:
            playersColetados+=1
            print(str(playersColetados)+" - Coletando dados de "+player.name)
            idsMatches = [match["id"] for match in player.relationships["matches"]["data"]]
            matches = []
            for idMatch in idsMatches:
                match = api.matches().get(idMatch)

                rosters = match.rosters

                for roster in rosters:
                    for participant in roster.participants:
                        if participant.name == player.name:
                            kills = participant.kills
                            winPlace = participant.attributes["stats"]["winPlace"]
                match ={
                    "mapName": match.attributes["mapName"],
                    "gameMode": match.attributes["gameMode"],
                    "date": match.attributes["createdAt"],
                    "kills": kills,
                    "rank": winPlace
                }
                matches.append(match)
            for match in matches:
                ws.append([player.name, match["mapName"], match["gameMode"], match["date"], match["kills"], match["rank"]])
    except:
        pass
wb.save('estatisticas.xlsx')

print("Fim!")
