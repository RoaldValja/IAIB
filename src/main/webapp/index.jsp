<!DOCTYPE html>
<html style="height:100%;">
<head>
	<meta charset="utf-8"/>
	<title>Veebiliides</title>
	<link rel="stylesheet" type="text/css" href="css/Veebiliides.css">
	<script src="https://code.jquery.com/jquery-3.4.1.js" type="text/javascript"></script>
	<script lang="javascript" src="js/xlsx.full.min.js"></script>
	<script src="js/xlsx.core.min.js"></script>
	<script src="js/FileSaver.js"></script>
	<script src="js/tableexport.js"></script>
	<script src="js/Veebiliides.js" defer></script>
	<script src="js/Examples.js" defer></script>
	
</head>
<body style="height:100%; background-color: gray; overflow: hidden;">
	<div id="menu" style="width:100%; height:10%; background-color: gray; float:left;">
		<div id="topLeftCorner" class="emptySpace" style="width:2%; height:100%; background-color: gray; float:left;">
		</div>
		<div id="menuArea" style="width:96%; height:100%; background-color: gray; float:left;">
			
			<div id="inputMenuArea" style="width:10%; height:100%; float:left;">
				<div id="menuTopInput" class="emptySpace" style="width:100%; height:20%; background-color: gray; float:left;">
				</div>
				<div class="menuObject" id="inputFileArea" style="width:100%; height:80%; background-color: green; float:left;">
					<span class="tooltipText" id="tooltipFile">Nupp, millega saad laadida peale planeerija andmed Excel failist.</span>
					<div class="menuButtonInput" id="inputFile" style="width:100%; height:100%;" onclick="getInputFile()">
						<div id="inputTopArea" style="width:100%; height:40%;">
							<span class="inputLine" id="spanInputFile">Sisendfail</span>
						</div>
						<div id="inputBottomArea" style="width:100%; height:60%">
							<input type="file" id="input-excel" onchange="getInputFile(event)"/>
						</div>
					</div>
				</div>
			</div>
			<div id="buttonEmptyArea1" class="emptySpace" style="width:3%; height:100%; background-color: gray; float:left;">
			</div>
			<div id="projectButtonsArea" style="width:25%; height:100%; background-color: gray; float:left;">
				<div id="projectButtonsTopArea" style="width:100%; height:45%; background-color: gray; float:left;">
					<div id="topMostEmptyArea" class="emptySpace" style="width:100%; height:10%; float:left;">
					</div>
					<div class="menuObject" id="projectNameArea" style="width:100%; height:80%; background-color: gray; float:left;">
						<span class="tooltipText" id="tooltipNameArea">Planeerija projekti nimi, mida kasutatakse faili loomisel.</span>
						<div id="preProjectNameArea" style="width:30%; height:100%; float:left; background-color: #d4d6d0; text-align: center; line-height:100%">
							<span id="spanProjectName" style="width:100%; height:100%; position:relative; top:15%; transform:translateY(-15%); font-weight: bold;">Projekti nimi:</span>
						</div>
						<div id="projectName" style="width:69.3%; height:100%; float:left;">
							<input type="text" id="inputProjectName" class="tableInput" name="getProjectName" placeholder="Projekti nimi" style="width:97.5%; height:80%">
						</div>
					</div>
					<div id="belowProjectNameArea" class="emptySpace" style="width:100%; height:10%; float:left;">
					</div>
				</div>
				<div id="projectButtonsBottomArea" style="width:100%; height:55%; background-color: gray; float:left;">
					<div class="menuButtonTable" id="newProject" style="width:30.8%; height:100%; border-left: 1px solid black; padding-left:1%; padding-right:1%;" onclick="newProject('tab')">
						<span class="singleLine" id="spanCreateNewProject">Kustuta projekt</span>
						<span class="tooltipText" id="tooltipNewProject">Kustutab olemasoleva projekti tabelid ja lipikud.</span>
					</div>
					<div class="menuButtonTable" id="generateExampleTable" style="width:31%; height:100%; border-left: 1px solid black; padding-left:1%; padding-right:1%;" onclick="generateExampleTable()">
						<span class="singleLine" id="spanCreateExampleTables">Loo näidistabelid</span>
						<span class="tooltipText" id="tooltipExamples">Loob näidistabelid planeerija jaoks.</span>
					</div>
					<div class="menuButtonTable" id="generateTemplateTable" style="width:30.8%; height:100%; border-left: 1px solid black; border-right: 1px solid black; padding-left:1%; padding-right:1%;" onclick="generateTemplateTable()">
						<span class="singleLine" id="spanCreateTableTemplates" style="top:12%">Loo tabelite<br>mallid</span>
						<span class="tooltipText" id="tooltipTemplates">Loob tabelite mallid planeerija jaoks.</span>
					</div>
				</div>
			</div>
			<div id="buttonEmptyArea2" class="emptySpace" style="width:3%; height:100%; background-color: gray; float:left;">
			</div>
			<div id="tableEditing" style="width:11%;height:100%; float:left;">
				<div id="menuTopEditing" class="emptySpace" style="width:100%; height:20%; background-color: gray; float:left;">
				</div>
				<div id="tableInputArea" style="height:80%; background-color: gray; float:left;">
					<div class="tableInputArea" style="width:96.5%; height:50%; float:left;">
						<input type="number" class="tableInput" id="tableRow" name="getTableRow" placeholder="Tabeli rida" style="width:97.5%; height:87%" min="0">
						<span class="tooltipText" id="tooltipTablerow">Siia kirjuta mitu tabeli rida tahad korraga luua. Seda sisendit kasutab nupp "lisa rida".</span>
					</div>
					<br>
					<div class="menuButtonTable" id="addRow" style="width:48.7%; height:50%; border-left: 1px solid black; padding-left:0%; padding-right:0%; float:left;" onclick="addRow()">
						<span class="singleLine" id="spanAddRow">Lisa rida</span>
						<span class="tooltipText" id="tooltipAddRow">Selle nupuga saad lisada aktiivsele tabelile ridu juurde.</span>
					</div>
					<div class="menuButtonTable" id="deleteRow" style="width:48.7%; height:50%; border-left: 1px solid black; border-right: 1px solid black; padding-left:0%; padding-right:0%; float:left;" onclick="removeRow()">
						<span class="singleLine" id="spanDeleteRow">Kustuta rida</span>
						<span class="tooltipText" id="tooltipDeleteRow">Selle nupuga saad kustutada aktiivselt tabelilt ühe rea korraga.</span>
					</div>
				</div>
			</div>
			<div id="buttonEmptyArea3" class="emptySpace" style="width:3%; height:100%; background-color: gray; float:left;">
			</div>
			<div id="endingArea" style="width:45%; height:100%; float:left;">
				<div id="menuTopEnding" class="emptySpace" style="width:100%; height:20%; background-color: gray; float:left;">
				</div>
				<div id="finishingButtonsArea" style="width:100%; height:80%; background-color: gray; float:left;">
					<div id="finishingButtonsFrontArea" style="width:24%; height:100%; background-color: gray; float:left;">
						<div class="menuButtonEnding" id="checkProject" style="width:45%; height:100%; border-left:1px solid black;" onclick="validate()">
							<span class="singleLineLarge" id="spanCheckProject" style="top:20%;">Kontrolli projekt</span>
							<span class="tooltipText" id="tooltipCheckProject">Selle nupuga saad valideerid oma projekti andmeid, et kas neil on vigu sees.</span>
						</div>
						<div class="menuButtonEnding" id="saveProject" style="width:45%; height:100%; border-left:1px solid black; border-right:1px solid black;" onclick="saveProject()">
							<span class="singleLineLarge" id="spanSaveProject" style="top:20%;">Salvesta projekt</span>
							<span class="tooltipText" id="tooltipSaveProject">Selle nupuga saad salvestada oma hetkest projekti. Salvestatakse planeeritavad ja planeeritud tabelid.</span>
						</div>
					</div>
					<div style="width:4%; height:100%; background-color:gray; float:left;"></div>
					<div id="finishingButtonsPlanArea" style="width:40%; height:100%; float:left;">
						<div class="tableInputArea" style="width:15%; height:50%; float:left;">
							<input type="number" class="tableInput" id="configHours" name="ConfigHours" placeholder="Tunnid" style="width:80%; height:87%; float:left;" value="0" min="0" max="9">
							<span class="tooltipText" id="tooltipConfigHours">Siia saad kirjutada planeerimise konfigureerimise aja tundides.</span>
						</div>
						<div class="tableInputArea" style="width:15%; height:50%; float:left;">
							<input type="number" class="tableInput" id="configMinutes" name="ConfigMinutes" placeholder="Minutid" style="width:80%; height:87%; float:left;" value="0" min="0" max="59">
							<span class="tooltipText" id="tooltipConfigMinutes">Siia saad kirjutada planeerimise konfigureerimise aja minutites.</span>
						</div>
						<div class="tableInputArea" style="width:15%; height:50%; float:left;">
							<input type="number" class="tableInput" id="configSeconds" name="ConfigSeconds" placeholder="Sekundid" style="width:80%;height:87%; float:left;" value="0" min="0" max="59">
							<span class="tooltipText" id="tooltipConfigSeconds">Siia saad kirjutada planeerimise konfigureerimise aja sekundites.</span>
						</div>
						<div class="tableInputArea" style="width:55%; height:50%; float:left;">
							<select id="configAlgorithm" name="ConfigAlgorithm" style="width:100%; height:100%; float:left;">
								<option value="TABU_SEARCH">Tabu Search</option>
								<option value="FIRST_FIT">First Fit</option>
								<option value="HILL_CLIMBING">Hill Climbing</option>
							</select>
							<span class="tooltipText" id="tooltipConfigAlgorithm">Siit saad valida planeerimise algoritmi.</span>
						</div>
						<div class="menuButtonEnding" id="planProject" style="width:100%; height:50%; padding-left:0%; padding-right:0%;" onclick="planProject()">
							<span class="singleLineLarge" id="spanPlanProject">Planeeri projekt</span>
							<span class="tooltipText" id="tooltipPlanProject">Selle nupuga paned planeerija tööle.</span>
						</div>
					</div>
					<div style="width:4%; height:100%; background-color:gray; float:left;"></div>
					<div id="finishingButtonsLoadArea" style="width:12%; height:100%; float:left;">
						<div class="menuButtonEnding" id="displayPlan" style="width:100%; height:100%;" onclick="displayPlan()">
							<span class="singleLineLarge" id="spanDisplayPlan">Kuva plaan</span>
							<span class="tooltipText" id="tooltipDisplayPlan">Selle nupuga kuvad hetkel mälus oleva plaani veebiliidesesse.</span>
						</div>
					</div>
					
					<div style="width:6%; height:100%; background-color:gray; float:left;"></div>
					<div id="finishingButtonsBackArea" style="width:10%; height:100%; background-color: gray; float:left;">
				<!--		<div class="dropdown" style="width: 100%; height: 49.5%;">
							<button onclick="languageDropdown()" class="dropbtn" style="width: 100%; height: 100%;">Keel</button>
							<div id="myDropdown" class="dropdown-content">
								<a href="#Eesti">Eesti</a>
								<a href="#English">English</a>
							</div> 
						</div>-->
						<div class="languageDropdown" style="width:100%; height:49.3%; float:left; position: relative; display: inline-block;">
							<div id="languageButton" class="menuButtonExtra" onclick="languageDropdown()" style="width:100%; height:100%; position: relative; display: inline-block;">
								<span class="singleLine" id="spanLanguage">Keel</span>
								<span class="tooltipText" id="tooltipLanguage">Selle nupuga saad valida programmi keele.</span>
							</div>
							<div id="roaldDropdown" class="dropdown-content2">
								<div id="languageEstonian" class="languageChoice" onclick="languageChoice('Estonian')" style="display: block; width:80px; height:40px;">
									<span class="singleLine" id="spanLanguageChoiceEstonian">Estonian</span>
								</div>
								<div class="buttonBorder" style="width:100%; height:1px; background-color:black; display: block;">
								</div>
								<div id="languageEnglish" class="languageChoice" onclick="languageChoice('English')" style="display: block; width:80px; height:40px;">
									<span class="singleLine" id="spanLanguageChoiceEnglish">English</span>
								</div>
								<!--<a href="#Eesti">Eesti</a>
								<a href="#English">English</a>-->
							</div>
						</div>
						<div class="buttonBorder" style="width:100%; height:1%; background-color: black; float:left;"></div>
						<div class="helpArea" style="width:100%; height:49.4%; position: relative; display: inline-block">
							<div id="helpButton" class="menuButtonExtra" onclick="helpTutorial()" style="width:100%; height:100%; position: relative; display: inline-block;">
								<span class="singleLine" id="spanHelp">Abi</span>
								<span class="tooltipText" id="tooltipHelp">Selle nupuga saad kuvada abiinfot nuppude kohta.</span>
							</div>
							<div id="helpMenu" class="helpMenuClass">
								<div id="helpMenu1" class="tutorial" style="display:block; width:100%; height:100%;">
									<div id="tutorialExit" class="helpButton" onclick="closeTutorial()" style="display:block; width:5%; height:10%; position:absolute; right:1%; top:1%; z-index: 1; text-align: center;">X
									</div>
									<div id="tutorialNext" class="helpButton" onclick="getTutorialCommand('next')" style="display: block; width: 20%; height: 10%; position: absolute; right:3%; bottom:-13%; z-index: 1; text-align: center;">Järgmine
									</div>
									<div id="tutorialPrevious" class="helpButton" onclick="getTutorialCommand('last')" style="display: block; width: 20%; height: 10%; position: absolute; left:3%; bottom:-13%; z-index: 1; text-align: center;">Eelmine
									</div>
									<div id="tutorialText" style="display: block; width: 85%; height: 95%; background-color: white; position: absolute; left:5%; top:5%; z-index: 1; text-align: center;">Siia tuleb tutooriali tekst
									</div>
									<div id="tutorialInputFile" class="helpButton" onclick="getTutorialPosition('inputFile', '0')" style="display: block; width: 22%; height: 14%; position: absolute; left: 100%; z-index: 1; text-align: center;">Sisendfail
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 0.2%; height: 14%; position: absolute; z-index: 1; left: 122%">
									</div>
									<div id="tutorialNewProject" class="helpButton" onclick="getTutorialPosition('newProject', '1')" style="display: block; width: 22%; height: 14%; position: absolute; left: 122.2%; z-index: 1; text-align: center;">Loo uus projekt
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 44.2%; height: 0.5%; position: absolute; left: 100%; z-index: 1; top: 14%">
									</div>
									<div id="tutorialGenerateExampleTable" class="helpButton" onclick="getTutorialPosition('generateExampleTable', '2')" style="display: block; width: 22%; height: 14%; position: absolute; left: 100%; top: 14.5%; z-index: 1; text-align: center;">Loo näidistabelid
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 0.2%; height: 14%; position: absolute; left: 122%; z-index: 1; top: 14.5%">
									</div>
									<div id="tutorialGenerateTemplateTable" class="helpButton" onclick="getTutorialPosition('generateTemplateTable', '3')" style="display: block; width: 22%; height: 14%; position: absolute; left: 122.2%; top: 14.5%; z-index: 1; text-align: center;">Loo tabelite mallid
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 44.2%; height: 0.5%; position: absolute; left: 100%; z-index: 1; top: 28.5%">
									</div>
									<div id="tutorialAddRow" class="helpButton" onclick="getTutorialPosition('addRow', '4')" style="display: block; width: 22%; height: 14%; position: absolute; left: 100%; top: 29%; z-index: 1; text-align: center;">Lisa rida
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 0.2%; height: 14%; position: absolute; left: 122%; z-index: 1; top: 29%">
									</div>
									<div id="tutorialAddColumn" class="helpButton" onclick="getTutorialPosition('addColumn', '5')" style="display: block; width: 22%; height: 14%; position: absolute; left: 122.2%; top: 29%; z-index: 1; text-align: center;">Lisa Veerg
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 44.2%; height: 0.5%; position: absolute; left: 100%; z-index: 1; top: 43%">
									</div>
									<div id="tutorialDeleteRow" class="helpButton" onclick="getTutorialPosition('deleteRow', '6')" style="display: block; width: 22%; height: 14%; position: absolute; left: 100%; top: 43.5%; z-index: 1; text-align: center;">Kustuta rida
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 0.2%; height: 14%; position: absolute; left: 122%; z-index: 1; top: 43.5%">
									</div>
									<div id="tutorialDeleteColumn" class="helpButton" onclick="getTutorialPosition('deleteColumn', '7')" style="display: block; width: 22%; height: 14%; position: absolute; left: 122.2%; top: 43.5%; z-index: 1; text-align: center;">Kustuta veerg
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 44.2%; height: 0.5%; position: absolute; left: 100%; z-index: 1; top: 57.5%">
									</div>
									<div id="tutorialAddTable" class="helpButton" onclick="getTutorialPosition('addTable', '8')" style="display: block; width: 22%; height: 14%; position: absolute; left: 100%; top: 58%; z-index: 1; text-align: center;">Lisa tabel
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 0.2%; height: 14%; position: absolute; left: 122%; z-index: 1; top: 58%">
									</div>
									<div id="tutorialAddTab" class="helpButton" onclick="getTutorialPosition('addTab', '9')" style="display: block; width: 22%; height: 14%; position: absolute; left: 122.2%; top: 58%; z-index: 1; text-align: center;">Lisa lipik
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 44.2%; height: 0.5%; position: absolute; left: 100%; z-index: 1; top: 72%">
									</div>
									<div id="tutorialDeleteTab" class="helpButton" onclick="getTutorialPosition('deleteTab', '10')" style="display: block; width: 22%; height: 14%; position: absolute; left: 100%; top: 72.5%; z-index: 1; text-align: center;">Kustuta lipik
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 0.2%; height: 14%; position: absolute; left: 122%; z-index: 1; top: 72.5%">
									</div>
									<div id="tutorialSaveProject" class="helpButton" onclick="getTutorialPosition('saveProject', '11')" style="display: block; width: 22%; height: 14%; position: absolute; left: 122.2%; top: 72.5%; z-index: 1; text-align: center;">Salvesta tabel
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 44.2%; height: 0.5%; position: absolute; left: 100%; z-index: 1; top: 86.5%">
									</div>
									<div id="tutorialPlanProject" class="helpButton" onclick="getTutorialPosition('planProject', '12')" style="display: block; width: 22%; height: 14%; position: absolute; left: 100%; top: 87%; z-index: 1; text-align: center;">Planeeri tabel
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 0.2%; height: 14%; position: absolute; left: 122%; z-index: 1; top: 87%">
									</div>
									<div id="tutorialErrorMessageArea" class="helpButton" onclick="getTutorialPosition('errorMessageArea', '13')" style="display: block; width: 22%; height: 14%; position: absolute; left: 122.2%; top: 87%; z-index: 1; text-align: center;">Veateated
									</div>
									<div class="tutorialDivideBorder" style="background-color: black; width: 44.2%; height: 0.5%; position: absolute; left: 100%; z-index: 1; top: 101%">
									</div>
									<div id="tutorialBackground" style="background-color: #a7a7a8; position: absolute; left: -2%; top: -4%; width:148.2%; height:123.5%">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div> 
		<div id="topRightCorner" class="emptySpace" style="width:2%; height:100%; background-color: gray; float:left;">
		</div>
	</div>
	<div id="menuContentDivider" class="emptySpace" style="width:100%; height:1%; background-color: gray; float:left;">
	</div>
	<div id="content" style="width:100%; height:81%; background-color: white; float:left;">
		<div id="tableArea" style="width:85%; height:100%; background-color: gray; float:left; overflow: hidden;">
			<div id="rowCounter" class="emptySpace" style="width:2.45%; height:96.5%; background-color: gray; float:left; overflow: hidden;">
			</div>
			<div id="tableRows" style="width:97.55%; height:100%; float:left;" onscroll="tableareaScroll()">
			</div>
		</div>
		<div id="errorMessages" style="width:13%; height:100%; background-color: white; float:left;">
			<div id="errorTopBorder" style="width:100%; height:0.4%; background-color: black; float:left;">
			</div>
			<div id="errorLeftBorder" style="width:2%; height:99.2%; background-color: black; float:left;">
			</div>
			<div id="errorMessageArea" class="errors" style="width:96%; height:99.2%; background-color: white; float:left; overflow-y: scroll; position: relative;">
				<div id="javaFinished">Pole planeerimisel</div>
				<div id="javaTimer">
					<div class="javaTimerSegment" id="javaTimerHours"></div>
					<div class="javaTimerSegment" id="javaTimerMinutes"></div>
					<div class="javaTimerSegment" id="javaTimerSeconds"></div>
				</div>
				<div id="errorMessageHeader" style="width:100%; height:10%; float:left; text-align: center; line-height: 100%; background-color: white;">
					<span id="spanErrorMessages" style="width: 100%; height: 100%; color: red; position: relative; top: 35%; transform: translateY(-35%); font-size: 20px; font-weight: bold;">Veateated</span>
				</div>
				<div id="resizeButtonBig" style="width:100%; height: 20px; float:left; background-color:yellow;" onclick="resizeErrorAreaBig()">resize
				</div>
				<div id="resizeButtonSmall" style="width:100%; height: 20px; float:left; background-color:yellow; display:none;" onclick="resizeErrorAreaSmall()">resize
				</div>
			</div>
			<div id="errorRightBorder" style="width:2%; height:99.2%; background-color: black; float:left;">
			</div>
			<div id="errorBottomBorder" style="width:100%; height:0.4%; background-color: black; float:left;">
			</div>
		</div>
		<div id="rightWall" class="emptySpace" style="width:2%; height:100%; background-color: gray; float:left;">
		</div>
	</div>
	<div id="footerContentDivider" class="emptySpace" style="width:100%; height:1%; background-color: gray; float:left;">
	</div>
	<div id="footer" style="width:100%; height:7%; background-color: cyan; float:left;">
		<div id="bottomLeftCorner" class="emptySpace" style="width:2%; height:100%; background-color: gray; float:left;">
		</div>
		<div id="footerArea" style="width:96%; height:100%; background-color: brown; float:left;">
			<div id="tabArea2" style="width:100%; height:80%; background-color: cyan; float:left;">
				<div id="tabs" style="width:40%; height:100%; background-color: #d4d6d0; float:left;">
				</div>
				<div id="tabBorder" style="width:0.1%; height:100%; background-color: black; float:left;">
				</div>
				<div id="tabFrontName" style="width:9.9%; height:100%; background-color: #d4d6d0; float:left; text-align: center; line-height: 100%;">
					<span class="multiLine" id="spanPlanningTables" style="width:100%; height:100%; position:relative; top:15%; transform:translateY(-15%); font-weight: bold;">Planeeritavad tabelid</span>
				</div>
				<div id="tabsDivider" class="emptySpace" style="width:2%; height:100%; background-color: gray; float:left;">
				</div>
				<div id="tabs2" style="width:40%; height:100%; background-color: #d4d6d0; float:left;">
				</div>
				<div id="tabBorder" style="width:0.1%; height:100%; background-color: black; float:left;">
				</div>
				<div id="tabBackName" style="width:7.9%; height:100%; background-color: #d4d6d0; float:left; text-align: center; line-height: 100%;">
					<span class="multiLine" id="spanPlannedTables" style="width:100%; height:100%; position:relative; top:15%; transform:translateY(-15%); font-weight: bold;">Planeeritud tabelid</span>
				</div>
			</div>
			<div id="footerBottom" class="emptySpace" style="width:100%; height:20%; background-color: gray; float:left;">
			</div>
		</div>
		<div id="bottomRightCorner" class="emptySpace" style="width:2%; height:100%; background-color: gray; float:left;">
		</div>
	</div>
</body>
</html>