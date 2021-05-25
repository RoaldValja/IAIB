var activeTable;
var activeTab = "";
var tabsArray = [];
var activeTableRow = 0;
var activeTableColumn = 0;
var activeTablePiece = "";
var errorMessageID = 0;
var errorMessageSeperatorID = 1;
var errorMessageTarget = [];
var lastErrorMessage;
var supervisorArray = [];
var authorArray = [];
var keywordArray = [];
var defenseCode = 0;
var currentSlot = "#empty";
var oldX = -1;
var oldY = -1;

function getActiveTable(){
	console.log(activeTable);
}

function sleep(ms) {
      return new Promise(resolve => setTimeout(resolve, ms));
   }

function generateNewTimeslotTable(){
	let days = document.getElementById("timeslotDays").value;
	let timeslotsPerDay = document.getElementById("timeslotTimeslotsPerDay").value;
	let sessions = document.getElementById("timeslotSessions").value;
	let startTime = document.getElementById("timeslotStartTime").value;
	let startDate = document.getElementById("timeslotStartDate").value;
	let closedTimeslots = document.getElementById("timeslotClosedTimeslots").value;
	let timeLength = document.getElementById("timeslotTimeLength").value;
	let breakLength = document.getElementById("timeslotBreakLength").value;
	generateTimeslotTable(days, timeslotsPerDay, sessions, startTime, startDate, "viimasel päeval", closedTimeslots, timeLength, breakLength, "ei");
	
}


function checkTabAndDelete(tabName){
	let i;
	if(tabsArray.includes(tabName)){
		for(i = 0; i < tabsArray.length; i++){
			if(tabsArray[i] == tabName){
				tabsArray.splice(i, i+1);
			}
		}
	}
}

async function displayPlan(){
	loadJSON(function(response) {
		let i;
		JSON_Data = JSON.parse(response);
		newProject('tab2');
		checkTabAndDelete("Planned Data");
		tableID = "Planned Data";
		addTab(tableID, 'tabs2');
		showTab("table"+tableID);
		generateTable(1, 11, 1);
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[0].innerHTML = "Kellaaeg";
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[1].innerHTML = "Kuupäev";
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[2].innerHTML = "Kaitsmise tüüp";
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[3].innerHTML = "Kaitsmise pealkiri";
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[4].innerHTML = "Kaitsmise autor";
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[5].innerHTML = "Kaitsmise juhendajad";
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[6].innerHTML = "Kaitsmise komisjoni liikmed";
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[7].innerHTML = "Ruumi number";
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[8].innerHTML = "Autori kommentaarid";
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[9].innerHTML = "Juhendaja kommentaarid";
		document.getElementById("tablePlanned Data").childNodes[0].childNodes[0].childNodes[10].innerHTML = "Komisjoni kommentaarid";
		let tableLength = JSON_Data.startTimeList.length;
		for(i = 0; i < tableLength; i++){
			addRow();
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[0].innerHTML = JSON_Data.startTimeList[i]["start time"] + "-" + JSON_Data.endTimeList[i]["end time"];
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[1].innerHTML = JSON_Data.dateList[i]["date"];
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[2].innerHTML = JSON_Data.defenseTypeList[i]["defense type"];
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[3].innerHTML = JSON_Data.defenseTitleList[i]["defense title"];
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[4].innerHTML = JSON_Data.defenseAuthorList[i]["defense author"];
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[5].innerHTML = JSON_Data.defenseAuthorsSupervisorsList[i]["defense authors supervisors"];
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[6].innerHTML = JSON_Data.defenseCommiteeList[i]["defense commitee members"];
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[7].innerHTML = JSON_Data.defenseRoomNumberList[i]["defense room number"];
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[8].innerHTML = JSON_Data.defenseCommentsAuthorList[i]["defense comments author"];
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[9].innerHTML = JSON_Data.defenseCommentsSupervisorList[i]["defense comments supervisor"];
			document.getElementById("tablePlanned Data").childNodes[0].childNodes[i+1].childNodes[10].innerHTML = JSON_Data.defenseCommentsCommissionList[i]["defense comments commission"];
		}
	 });
}

function sendPlannerConfigData(){
	let hours = document.getElementById("configHours").value;
	let minutes = document.getElementById("configMinutes").value;
	let seconds = document.getElementById("configSeconds").value;
	let algorithm = document.getElementById("configAlgorithm").value;
	
	let jsonData = '{ "hours":"' + hours + '", "minutes":"' + minutes + '", "seconds":"' + seconds + '", "algorithm":"' + algorithm + '"}';
	let data = JSON.stringify(jsonData);
	
	$.ajax({
	      type: 'POST',
	      url: "ServletConfig",
	      data: data,
	      dataType: "json",
	      contentType: 'application/json; charset=utf-8',
	      mimeType: 'application/json',
	      success: function(resultData) { alert("Save Complete") }
	});
}

async function planProject(){
	addJSONPlanData();
	sendPlannerConfigData();
	let lastTime = (new Date).getTime();
	
	$.get("ServletPlan", function(responseText) {
		if(responseText == "Planeerimisel"){
			if(chosenLanguage == "Estonian"){
				$("#javaFinished").text("Planeerimisel");
			} else if(chosenLanguage == "English"){
				$("#javaFinished").text("Being planned");
			}	
		}
        
        let textFileInterval = setInterval(function(){
    		let now = (new Date).getTime();
    		let deltaTime = now - lastTime;
    		
    		let fileData
    		$.get("ready.txt", function(data){
    	    	fileData = data;
    			if(fileData == "x"){
    				if(chosenLanguage == "Estonian"){
        				$("#javaFinished").text("Planeeritud");
    				} else if(chosenLanguage == "English"){
        				$("#javaFinished").text("Planned");
    				}
    				displayPlan();
    				clearInterval(textFileInterval);
    			}
    	    });
    		let totalTime = Math.ceil(deltaTime / 1000);
    		let hourTime = Math.floor(totalTime / 3600);
    		if(totalTime > 3600){
    			totalTime = totalTime - hourTime * 3600;
    		}
    		let minuteTime = Math.floor(totalTime / 60);
    		if(totalTime > 60){
    			totalTime = totalTime - minuteTime * 60;
    		}
    		let secondTime = totalTime;
    		if(hourTime > 0){
    			let hoursElement = document.getElementById("javaTimerHours");
				if(chosenLanguage == "Estonian"){
	    			hoursElement.innerHTML = "Tundi <br>" + hourTime;
				} else if(chosenLanguage == "English"){
	    			hoursElement.innerHTML = "Hours <br>" + hourTime;
				}
    			hoursElement.style.visibility = "visible";
    		}
    		if(minuteTime > 0){
    			let minutesElement = document.getElementById("javaTimerMinutes");
				if(chosenLanguage == "Estonian"){
	    			minutesElement.innerHTML = "Minutit <br>" + minuteTime;
				} else if(chosenLanguage == "English"){
	    			minutesElement.innerHTML = "Minutes <br>" + minuteTime;
				}
    			minutesElement.style.visibility = "visible";
    		}
    		if(secondTime > 0){
    			let secondsElement = document.getElementById("javaTimerSeconds");
				if(chosenLanguage == "Estonian"){
	    			secondsElement.innerHTML = "Sekundit <br>" + secondTime;
				} else if(chosenLanguage == "English"){
	    			secondsElement.innerHTML = "Seconds <br>" + secondTime;
				}
    			secondsElement.style.visibility = "visible";
    		}
    	}, 10000);
	});
}

function addJSONPlanData(){
	let tableData, tableName, tableLength;
	let table = document.getElementsByClassName("table");
	let jsonTable = '{ "table": [ ';
	for(i = 0; i < table.length; i++){
		tableName = table[i].id;
		tableData = getTableData(tableName);
		tableLengthRow = tableData.length;
		tableLengthColumn = tableData[0].length;
		jsonTable = jsonTable.concat(writeJSONObject(tableName, tableLengthRow, tableLengthColumn, tableData));
		if(i != table.length-1){
			jsonTable = jsonTable.concat(", ");
		}
	}
	jsonTable = jsonTable.concat(' ] }');

	let data = JSON.stringify(jsonTable);
	$.ajax({
	      type: 'POST',
	      url: "ServletPlan",
	      data: data,
	      dataType: "json",
	      contentType: 'application/json; charset=utf-8',
	      mimeType: 'application/json',
	      success: function(resultData) { alert("Save Complete") }
	});
}

function writeJSONObject(name, lengthRow, lengthColumn, data){
	let i, j;
	let jsonTable;
	jsonTable = '{ "name":"';
	jsonTable = jsonTable.concat(name);
	jsonTable = jsonTable.concat('", "tableSlot": [');
	for(i = 0; i < lengthRow; i++){
		for(j = 0; j < lengthColumn; j++){
			jsonTable = jsonTable.concat(' { "row":"');
			jsonTable = jsonTable.concat(i+1);
			jsonTable = jsonTable.concat('", "column":"');
			jsonTable = jsonTable.concat(j+1);
			jsonTable = jsonTable.concat('", "data":"');
			jsonTable = jsonTable.concat(data[i][j]);
			jsonTable = jsonTable.concat('" }');
			if(i*j != (lengthRow-1)*(lengthColumn-1)){
				jsonTable = jsonTable.concat(',');
			}
		}
	}
	jsonTable = jsonTable.concat(' ] }');
	return jsonTable;
}

 function loadJSON(callback) {   
   let xobj = new XMLHttpRequest();
   xobj.overrideMimeType("application/json");
   xobj.open('GET', 'json/plannedData.json', true);
   xobj.onreadystatechange = function () {
          if (xobj.readyState == 4 && xobj.status == "200") {
        	  callback(xobj.responseText);
          }
   };
   xobj.setRequestHeader("Cache-Control", "max-age=0");
   xobj.send(null);  
}

function fillTableFromInput(table, row, column, ID){
	let i, j, repeat = 0;
	let index1, index2;
	let data;
	for(i = 1; i <= row; i++){
		for(j = 1; j <= column; j++){
			repeat = table.indexOf('<td', repeat);
			index1 = table.indexOf('>', repeat) + 1;
			index2 = table.indexOf('</td>');
			repeat = index2 + 5;
			data = table.substring(index1, index2);
			table = table.substring(repeat-1);
			let domElement = document.getElementById(ID.concat('-').concat(i).concat('-').concat(j));
			if(ID == "tableConfiguration"){
				activeTable = ID;
				if(j == 2 && i > 1){
					domElement.childNodes[0].value = data;
				} else{
					domElement.innerHTML = data;
				}
			} else if(ID == "tableTimeslot"){
				activeTable = ID;
				if(j == 4 && i > 1){
					domElement.childNodes[0].value = data;
				} else if(j == 5 && i > 1){
					domElement.childNodes[0].value = data;
				} else if(j == 6 && i > 1){
					let keywords = data.split(",");
					let k;
					for(k = 0; k < (keywords.length-1); k++){
						domElement.childNodes[k+1].click();
					}
					for(k = 0; k < keywords.length; k++){
						domElement.childNodes[k].value = keywords[k];
					}
				} else {
					domElement.innerHTML = data;
				}
			} else if(ID == "tableAuthor"){
				activeTable = ID;
				if(j == 2 && i > 2){
					domElement.childNodes[0].value = data;
				} else if(j == 3 && i > 2){
					let supervisors = data.split(",");
					let k;
					for(k = 0; k < (supervisors.length-1); k++){
						domElement.childNodes[k+1].click();
					}
					for(k = 0; k < supervisors.length; k++){
						domElement.childNodes[k].value = supervisors[k];
					}
				} else if(j >= 4 && j <= 6 && i > 2){
					let keywords = data.split(",");
					let k;
					for(k = 0; k < (keywords.length-1); k++){
						domElement.childNodes[k+1].click();
					}
					for(k = 0; k < keywords.length; k++){
						domElement.childNodes[k].value = keywords[k];
					}
				} else if(j >= 7 && i > 2){
					domElement.childNodes[0].value = data;
				} else{
					domElement.innerHTML = data;
				}
			} else if(ID == "tableSupervisor"){
				activeTable = ID;
				if(j == 2 && i > 2){
					domElement.childNodes[0].value = data;
				} else if(j >= 3 && j <= 5 && i > 2){
					let keywords = data.split(",");
					let k;
					for(k = 0; k < (keywords.length-1); k++){
						domElement.childNodes[k+1].click();
					}
					for(k = 0; k < keywords.length; k++){
						domElement.childNodes[k].value = keywords[k];
					}
				} else if(j >= 6 && i > 2){
					domElement.childNodes[0].value = data;
				} else{
					domElement.innerHTML = data;
				}
			} else if(ID == "tableCommitee"){
				activeTable = ID;
				if(j == 2 && i > 2){
					domElement.childNodes[0].value = data;
				} else if(j == 3 && i > 2){
					domElement.childNodes[0].value = data;
				} else if(j >= 4 && j <= 6 && i > 2){
					let keywords = data.split(",");
					let k;
					for(k = 0; k < (keywords.length-1); k++){
						domElement.childNodes[k+1].click();
					}
					for(k = 0; k < keywords.length; k++){
						domElement.childNodes[k].value = keywords[k];
					}
				} else if(j >= 6 && i > 2){
					domElement.childNodes[0].value = data;
				} else{
					domElement.innerHTML = data;
				}
			} else if(ID == "tableDefense"){
				activeTable = ID;
				if(j >= 3 && j <= 5 && i > 1){
					domElement.childNodes[0].value = data;
				} else if(j >= 8 && j <= 9 && i > 1){
					domElement.childNodes[0].value = data;
				} else {
					domElement.innerHTML = data;
				}
			} else {
				domElement.innerHTML = data;
			}
			repeat = 0;
		}
	}
}

function fillTableFromJSON(data, row, column, ID, table){
	let i, j;
	let tableSlotNum;
	let tableRow;
	let tableColumn;
	let tableSlotData;
	let slot;
	for(i = 0; i < row; i++){
		tableSlotNum = column * i;
		for(j = 0; j < column; j++){
			slot = data.dateList[j];
			tableRow = slot.row;
			tableColumn = slot.column;
			tableSlotData = slot.data;
			document.getElementById(ID.concat('-').concat(i+1).concat('-').concat(j+1)).innerHTML = tableSlotData;
		}
	}
}

function getInputFile(input){
	let i;
	let reader = new FileReader();
	reader.readAsArrayBuffer(input.target.files[0]);
	reader.onload = function(input) {
                        let data = new Uint8Array(reader.result);
                        let wb = XLSX.read(data,{type:'array'});
						let numOfSheets = wb.SheetNames.length;
						newProject('tab');
						newProject('tab2');
						tabsArray.splice(0, tabsArray.length);
						for(i = 0; i < numOfSheets; i++){
							let sheetName = wb.SheetNames[i];
							let htmlstr = XLSX.write(wb,{sheet:sheetName, type:'string',bookType:'html'});
							if(sheetName == "Planned Data"){
								addTab(sheetName, 'tabs2');
							} else {
								addTab(sheetName, 'tabs');
							}
							let sheetID = 'table'.concat(sheetName);
							showTab(sheetID);
							let trCount = (htmlstr.match(new RegExp("<tr>", "g")) || []).length;
							let tdCount = (htmlstr.match(new RegExp("<td ", "g")) || []).length;
							let columnCount = tdCount / trCount;
							generateTable(trCount,columnCount,1);
							fillTableFromInput(htmlstr, trCount, columnCount, sheetID);
						}					
	}
}

function saveProject(){
	let i;
	let wb = XLSX.utils.book_new();
	wb.Props = {
	Title: "Example Excel",
	Subject: "Test file",
	Author: "Roald Välja",
	CreatedDate: new Date(2020,01,10)
	};
	let tableName = document.getElementsByClassName("table");
	for(i = 0; i < tableName.length; i++){
		wb.SheetNames.push(tableName[i].id.substring(5));
		let ws_data = getTableData(tableName[i].id);
		let ws = XLSX.utils.aoa_to_sheet(ws_data);
		wb.Sheets[tableName[i].id.substring(5)] = ws;
	}
	let wbout = XLSX.write(wb, {bookType:'xlsx', type:'binary'});
	let projectName = document.getElementById("inputProjectName").value + ".xlsx";
	saveAs(new Blob([s2ab(wbout)],{type:"application/octet-stream"}), projectName);
}

function s2ab(s){
	let buf = new ArrayBuffer(s.length);
	let view = new Uint8Array(buf);
	for(var i=0; i<s.length; i++){
		view[i] = s.charCodeAt(i) & 0xFF;
	}
	return buf;
}

function getTableData(name){
	let i, j;
	let tableRow = [];
	let table = [];
	let data = document.getElementById(name).childNodes[0].childNodes[0].childNodes[0].innerHTML;
	let tableLength = document.getElementById(name).childNodes[0].childNodes[0].childNodes.length;
	let rowLength = document.getElementById(name).childNodes[0].childNodes.length;
	let dataArray = [];
	for(i = 0; i < rowLength; i++){
		for(j = 0; j < tableLength; j++){
			if(name == "tableConfiguration"){
				if(i > 0 && j == 1){
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
				} else{
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].innerHTML;
				}
			} else if(name == "tableTimeslot"){
				if(i > 0 && j >= 3 && j <= 4){
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
				} else if(i > 0 && j == 5){
					let dataAmount = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childElementCount;
					if(dataAmount == 2){
						data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
					} else {
						let k;
						for(k = 0; k < dataAmount-1; k++){
							dataArray.push(document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[k].value);
						}
						data = dataArray.join();
						dataArray = [];
					}
				} else {
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].innerHTML;
				}
			} else if(name == "tableAuthor"){
				if(i > 1 && j == 1){
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
				} else if(i > 1 && j >= 6){
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
				} else if(i > 1 && j >= 2 && j <= 5){
					let dataAmount = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childElementCount;
					if(dataAmount == 2){
						data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
					} else {
						let k;
						for(k = 0; k < dataAmount-1; k++){
							dataArray.push(document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[k].value);
						}
						data = dataArray.join();
						dataArray = [];
					}
				} else {
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].innerHTML;
				}
			} else if(name == "tableSupervisor"){
				if(i > 1 && j == 1){
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
				} else if(i > 1 && j >= 5){
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
				} else if(i > 1 && j >= 2 && j <= 4){
					let dataAmount = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childElementCount;
					if(dataAmount == 2){
						data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
					} else {
						let k;
						for(k = 0; k < dataAmount-1; k++){
							dataArray.push(document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[k].value);
						}
						data = dataArray.join();
						dataArray = [];
					}
				} else {
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].innerHTML;
				}
			} else if(name == "tableCommitee"){
				if(i > 1 && j >= 1 &&  j <= 2){
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
				} else if(i > 1 && j >= 6){
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
				} else if(i > 1 && j >= 3 && j <= 5){
					let dataAmount = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childElementCount;
					if(dataAmount == 2){
						data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
					} else {
						let k;
						for(k = 0; k < dataAmount-1; k++){
							dataArray.push(document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[k].value);
						}
						data = dataArray.join();
						dataArray = [];
					}
				} else {
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].innerHTML;
				}
			} else if(name == "tableDefense"){
				if(i > 0 && j >= 2 &&  j <= 4){
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
				} else if(i > 0 && j >= 7 && j <= 8){
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].childNodes[0].value;
				} else {
					data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].innerHTML;
				}
			} else{
				data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].innerHTML;
			}
			tableRow.push(data);
		}
		table.push(tableRow);
		tableRow = [];
	}
	return table;
}

function refillActiveTab(){
	tabsArray = [];
	let tabs = document.getElementsByClassName('tab');
	for(i = 0; i < tabs.length; i++){
		tabsArray.push(tabs[i].id.substring(3,4).toLowerCase() + tabs[i].id.substring(4));
	}
}

function deleteTable(table){
	let deletableTable = document.getElementById(table);
	deletableTable.remove();
}

function deleteTab(){
	let tab = document.getElementById(activeTab);
	tab.remove();
	let toRemoveTable = activeTab.substring(0, 3) + "le" + activeTab.substring(3);
	deleteTable(toRemoveTable);
	refillActiveTab();
	let firstTab = document.getElementsByClassName('tab')[0].id;
	let table = firstTab.substring(0, 3) + "le" + firstTab.substring(3);
	showTab(table);
}

function showTab(table){
	let tables = document.getElementsByClassName('table');
	let rowTables = document.getElementsByClassName('rowTable');
	let i;
	for(i = 0; i < tables.length; i++){
		tables[i].style.display = "none";
		rowTables[i].style.display = "none";
	}
	document.getElementById(table).style.display = "block";
	document.getElementById(table + "-rows").style.display = "block";
	activeTable = table;
	
	let tabs = document.getElementsByClassName('tab');
	let j;
	for(j = 0; j < tabs.length; j++){
		tabs[j].style.backgroundColor = null;
	}
	activeTab = "tab" + table.substring(5,6).toUpperCase() + table.substring(6);
	document.getElementById(activeTab).style.backgroundColor = "#c3c7c9";
}

function addTab(tabName, tabArea){
	let tabValue, i;
	let getTab = [""];
	if(tabName == ""){
		tabValue = getTab[0].value;
	} else {
		tabValue = tabName;
	}
	if(tabValue.length == 0){
		errorMessage('Ei saa lisada lipikut, kui pole talle antud nime!', "addTab");
	} else if (tabsArray.includes(tabValue)){
		errorMessage('Ei saa panna lipiku nimeks ' + tabValue + ', kuna selle nimeline lipik on juba olemas!', "addTab");
	} else {
		let tabClickHandler = function(arg){
			return function() {showTab(arg);};
		}
		refillActiveTab();
		tabsArray.push(tabValue);
		
		let tab = document.createElement('div');
		if(tabArea == "tabs2"){
			tab.className = "tab2"
		} else {
			tab.className = "tab";
		}
		
		tableId = 'table' + tabValue.substring(0, 1).toUpperCase() + tabValue.substring(1);
		tab.id = "tab" + tabValue.substring(0, 1).toUpperCase() + tabValue.substring(1);
		tab.innerHTML = tabValue;
		tab.contentEditable = "false";
		tab.onclick = tabClickHandler(tableId);
		document.getElementById(tabArea).appendChild(tab);
		
		let table = document.createElement('table');
		table.className = "table";
		table.id = tableId;
		table.style.display = "none";
		document.getElementById('tableRows').appendChild(table);
		
		table = document.createElement('table');
		table.className = "rowTable";
		table.id = tableId + "-rows"
		table.style.display = "none";
		table.style.position = "absolute";
		table.style.zIndex = "3";
		document.getElementById("rowCounter").appendChild(table);
		
		getTab[0].value = "";
		showTab(tableId);
	}	
}

function languageDropdown(){
	document.getElementById("roaldDropdown").classList.toggle("show");
}

function helpTutorial(){
	document.getElementById("helpMenu").classList.toggle("show");
	let rect = document.getElementById("helpMenu");
	let rect2 = rect.getBoundingClientRect();
}

let tutorialTextArrayEstonian = {
	inputFile: "'Sisendfail' nupu ala on ära värvitud punase värviga. Projekti sisendfaili valimiseks vajutage nupule nimega 'Vali fail' ning otsige üles oma tabelite fail. Lubatud failid on Exceli failid või LibreOffice versiooni Calc failid. Nende failide lühendid on: .xlsx, .xls, .ods",
	newProject: "'Loo uus projekt' nupp kustutab kõik endised tabelid ja lipikud ära vanas projektis. Kui täidad nupu kohal oleva 'Projekti nimi' lahtri, siis vajutades 'Salvesta tabel' nupp loob Exceli faili, mille nime on 'Projekti nimi' lahtrist võetud nimi.",
	generateExampleTable: "'Loo näidistabelid' nupp kustutab kõik endised tabelid ja lipikud ära vanas projektis ning selle asemel loob uued tabelid ja lipikud, kus on olemas projekti jaoks sobilikud näidisandmed. Kasuta seda nuppu selleks, et teada mis struktuuriga ja missugused andmed on sobilikud planeerija jaoks.",
	generateTemplateTable: "'Loo tabelite mallid' nupp kustutab kõik endised tabelid ja lipikud ära vanas projektis ning selle asemel loob uued tabelid ja lipikud, kus on olemas ainult projekti jaoks sobilikud veeru nimed ning paar tühja rida. Kasuta seda nuppu selleks, et lihtsalt genereerida endale valmis planeerijaks sobilik mall.",
	addRow: "'Lisa rida' nupp loob all olevale aktiivsele tabelile juurde uue rea. Kui tahad lisada korraga rohkem kui 1 rida, siis kirjuta 'lisa rida' nupust vasakule olevalt vasakpoolsele lahtrisse number, mitu rida tahad lisada ning vajuta 'lisa rida' nuppu. Kui tahad lisada ridu tabelile konkreetse rea alla, siis vajuta selle lahtri peale, mille alla tahad lisada ridu ning vajuta nuppu 'lisa rida'. Kui tahad lisada ridu tabeli lõppu, siis vajuta kusagile tabeli alal olevale tühjale ruumile või veebiliidese hallile taustale. Selleks, et teada milline lahter on aktiivseks tehtud, vaata kas tabelil on mingi lahter ära värvitud beežika värviga.",
	addColumn: "'Lisa veerg' nupp loob all olevale aktiivsele tabelile juurde uue veeru. Kui tahad lisada korraga rohkem kui 1 veerg, siis kirjuta 'lisa rida' nupust vasakule olevalt parempoolsele lahtrisse number, mitu rida tahad lisada ning vajuta 'lisa veerg' nuppu. Kui tahad lisada veerge tabelile konkreetse veeru taha, siis vajuta selle lahtri peale, mille paremale poolele tahad lisada veerge ning vajuta nuppu 'lisa veerg'. Kui tahad lisada veerge tabeli lõppu, siis vajuta kusagile tabeli alal olevale tühjale ruumile või veebiliidese hallile taustale. Selleks, et teada milline lahter on aktiivseks tehtud, vaata kas tabelil on mingi lahter ära värvitud beežika värviga. Ainult kasuta seda nuppu, kui tabelile on vaja juurde lisada uusi kellaaegasid.",
	deleteRow: "'Kustuta rida' nupp kustutab aktiivseks tehtud lahtri rea. Aktiveeritud lahtri värv on beežikas. Nupp töötab ainult siis, kui on tehtud mingisugune tabeli lahter aktiivseks.",
	deleteColumn: "'Kustuta veerg' nupp kustutab aktiivseks tehtud lahtri veeru. Aktiveeritud lahtri värv on beežikas. Nupp töötab ainult siis, kui on tehtud mingisugune tabeli lahter aktiivseks.",
	addTable: "'Lisa tabel' nupp kustutab aktiive tabeli ära ning loob selle asemele uue tabeli. Tabeli ridade arvu valimiseks kirjuta 'lisa rida' nupust vasakule olevale vasakpoolsele lahtrisse number ning veergude arvu valimiseks kirjuta 'lisa rida' nupust vasakule olevale parempoolsele lahtrisse number. Nupp töötab ainult siis, kui oled kirjutanud tabeli rea ja veeru numbrid.",
	addTab: "'Lisa lipik' nupp lisab uue tabeli lipiku, kus saab luua uue tabeli. Lipikud asuvad veebiliideses alloleval äärel.",
	deleteTab: "'Kustuta lipik' nupp kustutab aktiivse tabeli ning selle lipiku ära.",
	saveProject: "'Salvesta tabel' nupp loob uue Exceli faili ja võtab nimeks 'Projekti nimi' lahtrist nime või kasutab programmi poolt valitud nime.",
	planProject: "'Planeeri tabel' nupp võtab veebiliideses olevad tabelite andmed ning saadab selle planeerijasse. Planeerija kirjutab saadud tulemused tagasi veebiliidesesse, lisades veebiliidesesse uued lipikud ja nende tabelid. Planeeritud lipikud asuvad veebiliideses all oleval ribal paremal pool.",
	errorMessageArea: "'Veateated' alal lisatakse uusi veateateid igakord kui kasutaja teeb midagi valesti. Veateated kirjeldavad probleemi lahti ning kui nende peale vajutada, siis värvitakse ära ala või nupp, kus oli tehtud viga. Olemasolevaid veateateid saab ära kustutada vajutades veateatel üleval paremal olevale ristile."
}

let tutorialTextArrayEnglish = {
	inputFile: "'Input file' button allows you to import a table file. The button allows you to import Excel files or LibreOffice Calc files. Those files suffixes are: .xlsx, .xls, .ods",
	newProject: "'Create new project' button deletes all of the current tables and tabs from the project. If you fill in 'Project name', then when you press 'Save table' button, the added project name will be put as the save files name.",
	generateExampleTable: "'Create example table' button deletes all of the current tables and tabs from the project and replaces them with new tables and tabs, that already contain sufficient sample data. Use this button to get to know the structure and what kinds of data are sufficient for the planner.",
	generateTemplateTable: "'Create table templates' button deletes all of the current tables and tabs from the project and replaces them with new tables and tabs, that contain only the sufficient column names and a few empty rows. Use this button to generate a sufficient template for your project.",
	addRow: "'Add row' button creates a new row into the currently active table. If you want to add more than 1 row, you must fill out the 'table row' field to the left of the 'Add row' button. If you want to add rows after a specific row, then you have to activate the above row and then press 'add row' button. If you want to add rows to the end of the table, then deactivate your current active slot by clicking on the empty table field or by clicking anywhere on the gray background area.",
	addColumn: "'Add column' button creates a new column into the currently active table. If you want to add more than 1 row, you must fill out the 'table column' field to the left of the 'Add row' button. If you want to add columns after a specific column, then you have to activate the left column and then press 'add column' button. If you want to add columns to the end of the table, then deactivate your current active slot by clicking on the empty table field or by clicking anywhere on the gray background area.",
	deleteRow: "'Delete row' button deletes the current active row. Activated slots color is beige. The button only works when you have activated a table slot.",
	deleteColumn: "'Delete column' button deletes the current active column. Activated slots color is beige. The button only works when you have activated a table slot.",
	addTable: "'Add table' button deletes the current active table and creates a new one to replace it. To give the table a certain amount of rows, fill out the 'Table row' field and to give the table a certain amount of columns, fill out the 'Table column' field. The button only works when you have writted row and column numbers in their fields.",
	addTab: "'Add tab' button adds a new tab where you can create a new table. Tabs are located at the bottom row of the screen.",
	deleteTab: "'Delete tab' button deletes the current active table and its tab.",
	saveProject: "'Save table' button creates a new Excel file and gives its name from the field 'Project file' or if you havent filled out the field, then it gives the file the programs chosen name.",
	planProject: "'Plan table' button takes the data from the project tables and sends them to the planner. Planner then writes new tables for the project by adding new tables and tabs and filling them out with planned data. Planned tabs are located at the bottom of the screen on the right side.",
	errorMessageArea: "'Error messages' area gets added new error messages everytime the user makes any mistakes. Error messages describe the problem and if you click on them, then it will highlight where you made the mistake. The existing error messages can be dismissed by clicking on the small X at the top right corner of the error message."
}

let tutorialTextKeysArray = ["inputFile", "newProject", "generateExampleTable", "generateTemplateTable", "addRow", "addColumn", "deleteRow", "deleteColumn", "addTable", "addTab", "deleteTab", "saveProject", "planProject", "errorMessageArea"];

let lastTutorialButton = "";
let lastTutorialHelpButton = "";
let tutorialPosition = 0;

function getTutorialPosition(id, position){
	let menuButton = document.getElementById(id);
	menuButton.style.backgroundColor = "#c3e4f7";
	
	let helpButtonId = "tutorial" + id.substring(0, 1).toUpperCase() + id.substring(1);
	let helpButton = document.getElementById(helpButtonId);
	helpButton.style.backgroundColor = "#d8dfe3";
	
	if(lastTutorialButton != "" && lastTutorialButton != id){
		document.getElementById(lastTutorialButton).style.backgroundColor = null;
		document.getElementById(lastTutorialHelpButton).style.backgroundColor = null;
	}
	if(chosenLanguage == "Estonian"){
		let tutorialText = tutorialTextArrayEstonian[id];
	} else if(chosenLanguage == "English"){
		let tutorialText = tutorialTextArrayEnglish[id];
	}
	document.getElementById("tutorialText").innerHTML = tutorialText;
	lastTutorialButton = id;
	lastTutorialHelpButton = helpButtonId;
	tutorialPosition = position;
}

function getTutorialCommand(command){
	let id;
	let newPosition;
	let intTutorialPosition = parseInt(tutorialPosition);
	if(command == "next"){
		if(intTutorialPosition == tutorialTextKeysArray.length-1){
			newPosition = 0;
		} else {
			newPosition = intTutorialPosition + 1;
		}
		id = tutorialTextKeysArray[newPosition];
		getTutorialPosition(id, newPosition);
	} else if(command == "last"){
		if(intTutorialPosition == 0){
			newPosition = tutorialTextKeysArray.length - 1;
		} else {
			newPosition = intTutorialPosition - 1;
		}
		id = tutorialTextKeysArray[newPosition];
		getTutorialPosition(id, newPosition);
	}
}

function closeTutorial(){
	document.getElementById("helpMenu").classList.toggle("show");
	if(lastTutorialButton != ""){
		document.getElementById(lastTutorialButton).style.backgroundColor = null;
	}
	document.getElementById("tutorialText").innerHTML = "";
	lastTutorialButton = "";
}

let chosenLanguage = "Estonian";

function languageChoice(language){
	if(language == "Estonian"){
		chosenLanguage = "Estonian";
		document.getElementById("spanLanguage").innerHTML = "Keel";
		document.getElementById("spanHelp").innerHTML = "Abi";
		document.getElementById("spanCheckProject").innerHTML = "Kontrolli projekt";
		document.getElementById("spanPlanProject").innerHTML = "Planeeri projekt";
		document.getElementById("spanSaveProject").innerHTML = "Salvesta projekt";
		document.getElementById("spanDeleteRow").innerHTML = "Kustuta rida";
		document.getElementById("spanAddRow").innerHTML = "Lisa rida";
		document.getElementById("tableRow").placeholder = "Tabeli rida";
		document.getElementById("spanDisplayPlan").innerHTML = "Kuva plaan";
		
		document.getElementById("spanCreateNewProject").innerHTML = "Loo uus projekt";
		document.getElementById("spanCreateNewProject").style.top = "30%";
		document.getElementById("spanCreateExampleTables").innerHTML = "Loo näidistabelid";
		document.getElementById("spanCreateExampleTables").style.top = "30%";
		document.getElementById("spanCreateTableTemplates").innerHTML = "Loo tabelite mallid";
		
		document.getElementById("spanProjectName").innerHTML = "Projekti nimi:";
		document.getElementById("inputProjectName").placeholder = "Projekti nimi";
		
		document.getElementById("spanInputFile").innerHTML = "Sisendfail";
		
		document.getElementById("spanErrorMessages").innerHTML = "Veateated";
		document.getElementById("spanPlanningTables").innerHTML = "Planeeritavad tabelid";
		document.getElementById("spanPlanningTables").style.top = "15%";
		document.getElementById("spanPlannedTables").innerHTML = "Planeeritud tabelid";
		document.getElementById("spanPlannedTables").style.top = "15%";
		
		document.getElementById("tutorialInputFile").innerHTML = "Sisendfail";
		document.getElementById("tutorialNewProject").innerHTML = "Loo uus projekt";
		document.getElementById("tutorialGenerateExampleTable").innerHTML = "Loo näidistabelid";
		document.getElementById("tutorialGenerateTemplateTable").innerHTML = "Loo tabelite mallid";
		document.getElementById("tutorialAddRow").innerHTML = "Lisa rida";
		document.getElementById("tutorialDeleteRow").innerHTML = "Kustuta rida";
		document.getElementById("tutorialSaveProject").innerHTML = "Salvesta projekt";
		document.getElementById("tutorialPlanProject").innerHTML = "Planeeri projekt";
		document.getElementById("tutorialErrorMessageArea").innerHTML = "Veateated";
		document.getElementById("tutorialNext").innerHTML = "Järgmine";
		document.getElementById("tutorialPrevious").innerHTML = "Eelmine";
		
		document.getElementById("tooltipFile").innerHTML = "Nupp, millega saad laadida peale planeerija andmed Excel failist.";
		document.getElementById("tooltipNameArea").innerHTML = "Planeerija projekti nimi, mida kasutatakse faili loomisel.";
		document.getElementById("tooltipNewProject").innerHTML = "Kustutab olemasoleva projekti tabelid ja lipikud.";
		document.getElementById("tooltipExamples").innerHTML = "Loob näidistabelid planeerija jaoks.";
		document.getElementById("tooltipTemplates").innerHTML = "Loob tabelite mallid planeerija jaoks.";
		document.getElementById("tooltipTablerow").innerHTML = 'Siia kirjuta mitu tabeli rida tahad korraga luua. Seda sisendit kasutab nupp "lisa rida".';
		document.getElementById("tooltipAddRow").innerHTML = "Selle nupuga saad lisada aktiivsele tabelile ridu juurde.";
		document.getElementById("tooltipDeleteRow").innerHTML = "Selle nupuga saad kustutada aktiivselt tabelilt ühe rea korraga.";
		document.getElementById("tooltipCheckProject").innerHTML = "Selle nupuga saad valideerid oma projekti andmeid, et kas neil on vigu sees.";
		document.getElementById("tooltipSaveProject").innerHTML = "Selle nupuga saad salvestada oma hetkest projekti. Salvestatakse planeeritavad ja planeeritud tabelid.";
		document.getElementById("tooltipConfigHours").innerHTML = "Siia saad kirjutada planeerimise konfigureerimise aja tundides.";
		document.getElementById("tooltipConfigMinutes").innerHTML = "Siia saad kirjutada planeerimise konfigureerimise aja minutites.";
		document.getElementById("tooltipConfigSeconds").innerHTML = "Siia saad kirjutada planeerimise konfigureerimise aja sekundites.";
		document.getElementById("tooltipConfigAlgorithm").innerHTML = "Siit saad valida planeerimise algoritmi.";
		document.getElementById("tooltipPlanProject").innerHTML = "Selle nupuga paned planeerija tööle.";
		document.getElementById("tooltipDisplayPlan").innerHTML = "Selle nupuga kuvad hetkel mälus oleva plaani veebiliidesesse.";
		document.getElementById("tooltipLanguage").innerHTML = "Selle nupuga saad valida programmi keele.";
		document.getElementById("tooltipHelp").innerHTML = "Selle nupuga saad kuvada abiinfot nuppude kohta.";
		
		let javaFinished = document.getElementById("javaFinished");
		if(javaFinished.innerHTML == "Not being planned"){
			javaFinished.innerHTML = "Pole planeerimisel";
		}
		
	} else if (language == "English"){
		chosenLanguage = "English";
		document.getElementById("spanLanguage").innerHTML = "Language";
		document.getElementById("spanHelp").innerHTML = "Help";
		document.getElementById("spanCheckProject").innerHTML = "Check table";
		document.getElementById("spanPlanProject").innerHTML = "Plan table";
		document.getElementById("spanSaveProject").innerHTML = "Save table";
		document.getElementById("spanDeleteRow").innerHTML = "Delete row";
		document.getElementById("spanAddRow").innerHTML = "Add row";
		document.getElementById("tableRow").placeholder = "Table row";
		document.getElementById("spanDisplayPlan").innerHTML = "Display plan";
		
		document.getElementById("spanCreateNewProject").innerHTML = "Create new project";
		document.getElementById("spanCreateNewProject").style.top = "15%";
		document.getElementById("spanCreateExampleTables").innerHTML = "Create example tables";
		document.getElementById("spanCreateExampleTables").style.top = "15%";
		document.getElementById("spanCreateTableTemplates").innerHTML = "Create table templates";
		
		document.getElementById("spanProjectName").innerHTML = "Project name:";
		document.getElementById("inputProjectName").placeholder = "Project name";
		
		document.getElementById("spanInputFile").innerHTML = "Input file";
		
		document.getElementById("spanErrorMessages").innerHTML = "Error messages";
		document.getElementById("spanPlanningTables").innerHTML = "Planning tables";
		document.getElementById("spanPlanningTables").style.top = "30%";
		document.getElementById("spanPlannedTables").innerHTML = "Planned tables";
		document.getElementById("spanPlannedTables").style.top = "30%";
		
		document.getElementById("tutorialInputFile").innerHTML = "Input file";
		document.getElementById("tutorialNewProject").innerHTML = "Create new project";
		document.getElementById("tutorialGenerateExampleTable").innerHTML = "Create example tables";
		document.getElementById("tutorialGenerateTemplateTable").innerHTML = "Create table templates";
		document.getElementById("tutorialAddRow").innerHTML = "Add row";
		document.getElementById("tutorialDeleteRow").innerHTML = "Delete row";
		document.getElementById("tutorialSaveProject").innerHTML = "Save project";
		document.getElementById("tutorialPlanProject").innerHTML = "Plan project";
		document.getElementById("tutorialErrorMessageArea").innerHTML = "Error messages";
		document.getElementById("tutorialNext").innerHTML = "Next";
		document.getElementById("tutorialPrevious").innerHTML = "Previous";
		

		document.getElementById("tooltipFile").innerHTML = "This button lets you import Excel file input data.";
		document.getElementById("tooltipNameArea").innerHTML = "Write the planning project name here, which will be used when creating save file.";
		document.getElementById("tooltipNewProject").innerHTML = "Deletes existing project tables and tabs.";
		document.getElementById("tooltipExamples").innerHTML = "Creates example tables for the planner.";
		document.getElementById("tooltipTemplates").innerHTML = "Creates template tables for the planner.";
		document.getElementById("tooltipTablerow").innerHTML = 'Here you write how many table rows you want to create. This input is used by "Add row" button.';
		document.getElementById("tooltipAddRow").innerHTML = "This button adds new rows to current visible table.";
		document.getElementById("tooltipDeleteRow").innerHTML = "This button deletes a row from the current visible table.";
		document.getElementById("tooltipCheckProject").innerHTML = "This button validates projects data.";
		document.getElementById("tooltipSaveProject").innerHTML = "This button saves current project. It saves planning and planned tables.";
		document.getElementById("tooltipConfigHours").innerHTML = "Here you can write how many hours you want the project to plan for.";
		document.getElementById("tooltipConfigMinutes").innerHTML = "Here you can write how many minutes you want the project to plan for.";
		document.getElementById("tooltipConfigSeconds").innerHTML = "Here you can write how many seconds you want the project to plan for.";
		document.getElementById("tooltipConfigAlgorithm").innerHTML = "Here you choose the planning algorithm.";
		document.getElementById("tooltipPlanProject").innerHTML = "This button initiates the planner.";
		document.getElementById("tooltipDisplayPlan").innerHTML = "This button retrieves planned data from the last plan.";
		document.getElementById("tooltipLanguage").innerHTML = "This button lets you choose applications language.";
		document.getElementById("tooltipHelp").innerHTML = "This button displays what each button does.";
		
		let javaFinished = document.getElementById("javaFinished");
		if(javaFinished.innerHTML == "Pole planeerimisel"){
			javaFinished.innerHTML = "Not being planned";
		}
	}
}

function errorMessage(message, target){
	let span, i;
	if(lastErrorMessage != message){
		if(errorMessageTarget.includes(target)){
			let errorIndex;
			for(i = 0; i < errorMessageTarget.length; i++){
				if(errorMessageTarget[i] == target){
					errorIndex = i;
				}
			}
			document.getElementById("errorMessageNumber-" + errorIndex).remove();
			
			if(document.getElementsByClassName("errorMessage").length > 0){
				document.getElementById("errorMessageSeperator-" + errorMessageSeperatorID).remove();
				errorMessageSeperatorID++;
			}
		}
		
		// childNodes.length > 3 on kuna childnodid leiavad 2 text node, mis on tühjad.
		if(document.getElementById("errorMessageArea").childNodes.length > 3){
			span = document.createElement('span');
			span.className = "errorMessageSeperator";
			span.id = "errorMessageSeperator-" + errorMessageID;
			span.innerHTML = "----------------------";
			document.getElementById("errorMessageArea").appendChild(span);
		}
		
		span = document.createElement('span');
		span.className = "errorMessage";
		span.id = "errorMessageNumber-" + errorMessageID;
		span.innerHTML = message;
		document.getElementById("errorMessageArea").appendChild(span);
		errorMessageID++;
		errorMessageTarget.push(target);
		lastErrorMessage = message;
		flashError();
	}
}

function flashError(){
	let div = document.getElementById("errorMessageHeader");
	let sum = 0;
	let interval = setInterval(frame, 250);
	function frame(){
		if(sum == 2000){
			clearInterval(interval);
		} else {
			sum = sum + 250;
			if(div.style.backgroundColor == "white"){
				div.style.backgroundColor = "#e67e65";
			} else {
				div.style.backgroundColor = "white";
			}
		}
	}
}


function newProject(tab){
	let tables = document.getElementsByClassName('table');
	let tabs = document.getElementsByClassName(tab);
	let i;
	let tabsName;
	document.getElementById("timeslotCustomCreate").style.visibility = "hidden";
	if(tab == "tab"){
		tabsName = "tabs";
	} else if(tab == "button"){
		tabsArray.splice(0, tabsArray.length);
		tabsName = "tabs2";
	} else {
		tabsName = "tabs2";
	}
	tableLength = tabs.length;
	for(i = tableLength-1; i >= 0; i--){
		document.getElementById('tableRows').removeChild(tables[i]);
		document.getElementById(tabsName).removeChild(tabs[i]);
	}
	activeTable = null;
}

function generateTemplateTable(){
	newProject('tab');
	addTab('Configuration', 'tabs');
	showTab('tableConfiguration');
	generateTable(23,4,1);
	addTab('Timeslot', 'tabs');
	showTab('tableTimeslot');
	generateTable(1,6,1);
	addTab('Supervisor', 'tabs');
	showTab('tableSupervisor');
	generateTable(7,6,2);
	addTab('Author', 'tabs');
	showTab('tableAuthor');
	generateTable(7,7,2);
	addTab('Commitee', 'tabs');
	showTab('tableCommitee');
	generateTable(7,7,2);
	addTab('Defense', 'tabs');
	showTab('tableDefense');
	generateTable(6,9,1);
	
	generateConfigurationTable();
	generateTimeslotTableTemplate();
	generateAuthorTableTemplate();
	generateSupervisorTableTemplate();
	generateCommiteeTableTemplate();
	generateDefenseTableTemplate();
	
}

function generateExampleTable(){
	newProject('tab');
	addTab('Configuration', 'tabs');
	showTab('tableConfiguration');
	generateTable(23,4,1);
	addTab('Timeslot', 'tabs');
	showTab('tableTimeslot');
	generateTable(1,6,1);
	addTab('Supervisor', 'tabs');
	showTab('tableSupervisor');
	generateTable(2,6,2);
	addTab('Author', 'tabs');
	showTab('tableAuthor');
	generateTable(2,7,2);
	addTab('Commitee', 'tabs');
	showTab('tableCommitee');
	generateTable(2,7,2);
	addTab('Defense', 'tabs');
	showTab('tableDefense');
	generateTable(1,9,1);

	generateConfigurationTable();
	showTab('tableTimeslot');
	generateTimeslotTable("6", "20", "2", "9:00", "13.04.2021", "viimasel päeval", "5", "20", "60", "yes");	// 100 kaitsja omad
//	generateTimeslotTable("1", "20", "2", "9:00", "13.04.2021", "viimasel päeval", "2", "20", "60", "yes");	// 10 kaitsja omad
	showTab('tableSupervisor');
	document.querySelector('#tabSupervisor').click();
	generateSupervisorTable("20");	// 100 kaitsja omad
//	generateSupervisorTable("10"); // 10 kaitsja omad
	showTab('tableAuthor');
	document.querySelector('#tabAuthor').click();
	generateAuthorTable("100");	// 100 kaitsja omad
//	generateAuthorTable("10");		// 10 kaitsja omad
	
	showTab('tableCommitee');
	document.querySelector('#tabCommitee').click();
	generateCommiteeTable("6");
	showTab('tableDefense');
	document.querySelector('#tabDefense').click();
	generateDefenseTable("100");	// 100 kaitsja omad
//	generateDefenseTable("10");	// 10 kaitsja omad	
}

function generateTable(row, column, header){
	let i, j;
	
	if(row == '' && column == '' && header == ''){
		row = document.getElementsByName('getTableRow')[0].value;
		column = document.getElementsByName('getTableColumn')[0].value;
		header = 1;
	}
	document.getElementsByName('getTableRow')[0].value = ""
	
	let thead = document.createElement('thead');
	let tbody = document.createElement('tbody');
	let rowTbody = document.createElement('tbody');
	rowTbody.style.width = "100%";
	let getActiveTable = document.getElementById(activeTable);
	
	while(getActiveTable.firstChild){
		getActiveTable.removeChild(getActiveTable.firstChild);
	}
	if(activeTable == "tableAuthor" || activeTable == "tableSupervisor" || activeTable == "tableCommitee"){
		header = 2;
		if(row >= 2){
			for(i = 0; i < 2; i++){
				let tr = document.createElement('tr');
				let getI = i+1;
				let rowId = getI.toString();
					for(j = 0; j < column; j++){
						let td;
						let getJ = j+1;
						if(i < header){
							bold = true;
						} else {
							bold = false;
						}
						td = document.createElement('td');
						td.className = "tableRowClass";
						td.id = activeTable.concat('-', rowId,'-', getJ);
						td.innerHTML = rowId.concat('-', getJ);
						td.style.height = "22px";
						td.contentEditable = "true";
						td.style.textAlign = "center";
						if(i < header){
							td.style.fontWeight = "900";
						}
						tr.appendChild(td);
					}
				tbody.appendChild(tr);
				
				tr = document.createElement('tr');
				let td = document.createElement('td');
				//td.className = "rowForTableClass";
				td.className = "tableRowClass";
				td.id = activeTable + "-" + rowId;
				td.innerHTML = rowId;
				td.style.height = "22px";
				td.style.width = "100%";
				td.style.textAlign = "center";
				td.style.fontWeight = "900";
				td.style.paddingBottom = "3.9px";
				tr.appendChild(td);
				rowTbody.appendChild(tr);
				document.getElementById(activeTable + "-rows").appendChild(rowTbody);
				document.getElementById(activeTable).appendChild(tbody);
			}
			
			document.getElementById("tableRow").value = row - 2;
			addRow();
		}
		
	}
	else if(activeTable == "tableTimeslot" || activeTable == "tableDefense" || activeTable == "tableConfiguration" || activeTable == "tablePlanned Data"){
		header = 1;
		if(row >= 1){
			for(i = 0; i < 1; i++){
				let tr = document.createElement('tr');
				let getI = i+1;
				let rowId = getI.toString();
					for(j = 0; j < column; j++){
						let td;
						let getJ = j+1;
						if(i < header){
							bold = true;
						} else {
							bold = false;
						}
						td = document.createElement('td');
						td.className = "tableRowClass";
						td.id = activeTable.concat('-', rowId,'-', getJ);
						td.innerHTML = rowId.concat('-', getJ);
						td.style.height = "22px";
						td.contentEditable = "true";
						td.style.textAlign = "center";
						if(i < header){
							td.style.fontWeight = "900";
						}
						tr.appendChild(td);
					}
				tbody.appendChild(tr);
				tr = document.createElement('tr');
				let td = document.createElement('td');
				td.className = "rowForTableClass";
				td.id = activeTable + "-" + rowId;
				td.innerHTML = rowId;
				td.style.height = "22px";
				td.style.width = "100%";
				td.style.textAlign = "center";
				td.style.fontWeight = "900"
				td.style.paddingBottom = "3.9px";
				tr.appendChild(td);
				rowTbody.appendChild(tr);
				document.getElementById(activeTable + "-rows").appendChild(rowTbody);
				document.getElementById(activeTable).appendChild(tbody);
			}
			
			document.getElementById("tableRow").value = row - 1;
			addRow();
		}	
	}
}



function insertAfterRow(newNode, activeNode){
	activeNode.parentNode.parentNode.insertBefore(newNode, activeNode.parentNode.nextSibling);
}
function insertAfterColumn(newNode, activeNode){
	activeNode.parentNode.insertBefore(newNode, activeNode.nextSibling);
}

function addRow(){
	let tableRowValue = document.getElementById("tableRow").value;
	let newRows = parseInt(tableRowValue, 10);
	if(activeTable == null){
		errorMessage('Ei saa lisada tabeli rida tabelisse, mida pole olemas!', "addRow");
	}
	else if(Number.isInteger(newRows) || tableRowValue == ""){
		let i, j;
		let getActiveTable = document.getElementById(activeTable);
		let tbody = getActiveTable.childNodes;
		let newRowsMax = 1;
		if(tableRowValue != ""){
			newRowsMax = newRows;
		}
		for(j = 0; j < newRowsMax; j++){
			let tr = document.createElement('tr');
			let columns = 1;
			let rows = 1;
			if(getActiveTable.childElementCount > 0){
				columns = tbody[0].childNodes[0].childNodes.length;
				rows = tbody[0].childNodes.length + 1;
				let rowsStr = "";
				for(i = 0; i < columns; i++){
					let getI = i+1;
					rowsStr = rows.toString();
					let td = document.createElement('td');
					td.className = "tableRowClass";
					td.id = activeTable.concat('-', rowsStr, '-', getI);
					td.style.minWidth = "50px";
					td.style.padding = "0px";
					td.style.height = "22px";
					addTdInfo(td, rows, getI);
					tr.appendChild(td);
				}
				if(activeTableRow == 0 && activeTableColumn == 0){
					tbody[0].appendChild(tr);
				} 
				else if(activeTableRow != 0 && activeTableColumn != 0){
					let rowID = activeTable + "-" + activeTableRow + "-" + activeTableColumn;
					let rowElement = document.getElementById(rowID);
					insertAfterRow(tr, rowElement);
					correctRows(activeTableRow, activeTableColumn);
				}
				
				let rowTd = document.createElement('td');
				let rowTr = document.createElement('tr');
				let rowNum = document.getElementById(activeTable + "-rows").childNodes[0].childElementCount + 1;
				rowTd.className = "rowForTableClass";
				rowTd.id = activeTable + "-" + rowNum;
				rowTd.style.height = "22.3px";
				rowTd.style.textAlign = "center";
				rowTd.style.fontWeight = "900";
				rowTd.style.paddingBottom = "3.9px";
				rowTd.innerHTML = rowNum;
				rowTr.appendChild(rowTd);
				document.getElementById(activeTable + "-rows").childNodes[0].appendChild(rowTr);
			} else{
				errorMessage('Tabeli rida ei saa sisestada, kui pole olemas algset tabelit. Palun looge uus tabel.', "tableRow");	
			}
		}
		document.getElementById("tableRow").value = "";
	}
	else {
		errorMessage('Tabeli reaks sisestati "' + tableRowValue + '", mis pole täisarvuline sisend!', "tableRow");	
	}
		
}

function addTdInfo(td, row, column){
	let i;
	if(activeTable == "tableConfiguration"){
		if(column == 2 && row != 1){
			makeNumberTableCell(td, activeTable, row, column, "constraintWeight", 1, 2, 999)
		}
	}else if(activeTable == "tableTimeslot"){
		if(column == 1 && row != 1){
			let time = "";
			if(row == 2){
				time = "01.01.2020";
			}
			else{
				let lastDate = document.getElementById(activeTable + '-' + (row - 1) + '-' + column).innerHTML;
				time = lastDate;
			}
			makeNormalTableCell(td, "center", "true", time);
		}
		else if(column == 2 && row != 1){
			let time = "";
			if(row == 2){
				time = "00:00";
			}
			else{
				let lastEndTime = document.getElementById(activeTable + '-' + (row - 1) + '-' + (column + 1)).innerHTML;
				time = lastEndTime;
			}
			makeNormalTableCell(td, "center", "true", time);
		}
		else if(column == 3 && row != 1){
			let time = "";
			if(row == 2){
				time = "00:00";
			}
			else{
				let startTime = document.getElementById(activeTable + '-' + (row - 1) + '-' + column).innerHTML;
				let lastEndTime = document.getElementById(activeTable + '-' + (row - 1) + '-' + (column - 1)).innerHTML;
				let startTimeInt = parseInt(startTime.substr(0, 2)) * 60 + parseInt(startTime.substr(3,2));
				let lastEndTimeInt = parseInt(lastEndTime.substr(0, 2)) * 60 + parseInt(lastEndTime.substr(3,2));
				let newTime = startTimeInt - lastEndTimeInt;
				let hours = 0, minutes = 0;
				if(newTime >= 60){
					hours = Math.round(newTime / 60);
					minutes = newTime - hours*60;
				} else {
					minutes = newTime;
				}
				let startTimeHours = parseInt(startTime.substr(0,2));
				let startTimeMinutes = parseInt(startTime.substr(3,2));
				startTimeHours += hours;
				if(startTimeMinutes + minutes >= 60){
					startTimeHours += 1;
					startTimeMinutes = startTimeMinutes + (minutes-60);
				} else {
					startTimeMinutes += minutes;
				}
				if(startTimeMinutes <= 9){
					startTimeMinutes = "0" + startTimeMinutes;
				}

				if(startTimeHours <= 9){
					startTimeHours = "0" + startTimeHours;
				}
				let result = startTimeHours + ":" + startTimeMinutes;
				time = result;
			}
			makeNormalTableCell(td, "center", "true", time);
		}
		else if(column == 4 && row != 1){
			let optionArray = ["Lahtine", "Kinnine", "Vaheaeg"];
			makeSelectTableCell(td, activeTable, row, column, "defenseType", optionArray, "true");
		}
		else if(column == 5 && row != 1){
			makeNumberTableCell(td, activeTable, row, column, "sessionNumber", 1, 2, 99)
		}
		else if(column == 6 && row > 1){
			multiDatalist(td, row, column, "", keywordArray);
			addAdditionalData(td, row, column);
		}
	}
	else if(activeTable == "tableAuthor"){
		if(column > 6 && row == 1){
			let timeslotRowLength = document.getElementById("tableTimeslot-1-1").parentNode.parentNode.childElementCount;
			let date = document.getElementById("tableTimeslot-" + (column - 3) + "-1").innerHTML;
			td.innerHTML = date;
			td.style.fontWeight = "900";
		}
		else if(column > 6 && row == 2){
			let timeslotRowLength = document.getElementById("tableTimeslot-1-1").parentNode.parentNode.childElementCount;
			let startTime = document.getElementById("tableTimeslot-" + (column - 3) + "-2").innerHTML;
			let endTime = document.getElementById("tableTimeslot-" + (column - 3) + "-3").innerHTML;
			let time = startTime + "-" + endTime;
			td.innerHTML = time;
			td.style.fontWeight = "900";
		}
		if(column == 1 && row > 2){
			makeNormalTableCell(td, "left", "true", "");
		}
		else if(column == 2 && row > 2){
			let optionArray = ["Jah", "Ei"];
			makeSelectTableCell(td, activeTable, row, column, "prerequisites", optionArray, "true");
		}
		else if(column == 3 && row > 2){
			multiDatalist(td, row, column, "", supervisorArray);
			addAdditionalData(td, row, column);
			td.style.textAlign = "left";
		}
		else if(column >= 4 && row > 2 && column <= 6){
			multiDatalist(td, row, column, "", keywordArray);
			addAdditionalData(td, row, column);
		}
		else if(column > 6 && row > 2){
			let optionArray = ["", "Eelistab", "Ei eelista", "Ei sobi"];
			makeSelectTableCell(td, activeTable, row, column, "sessionAvailability", optionArray, "true");
		}
	}
	else if(activeTable == "tableSupervisor"){
		if(column == 1 && row > 2){
			makeNormalTableCell(td, "left", "true", "");
		}
		else if(column == 2 && row > 2){
			let optionArray = ["Peajuhendaja", "Kaasjuhendaja"];
			makeSelectTableCell(td, activeTable, row, column, "supervisorRole", optionArray, "false");
		}
		else if(column >= 3 && row > 2 && column <= 5){
			multiDatalist(td, row, column, "", keywordArray);
			addAdditionalData(td, row, column);
		}
		else if(column > 5 && row > 2){
			let optionArray = ["", "Eelistab", "Ei eelista", "Ei sobi"];
			makeSelectTableCell(td, activeTable, row, column, "sessionAvailability", optionArray, "true");
		}
	}
	else if(activeTable == "tableCommitee"){
		if(column == 1 && row > 2){
			makeNormalTableCell(td, "left", "true", "");
		}
		else if(column == 2 && row > 2){
			let optionArray = ["Doktor", "Magister"];
			makeSelectTableCell(td, activeTable, row, column, "degree", optionArray, "false");
		}
		else if(column == 3 && row > 2){
			let optionArray = ["Ei", "Esimees", "Aseesimees"];
			makeSelectTableCell(td, activeTable, row, column, "chairman", optionArray, "false");
		}
		else if(column >= 4 && row > 2 && column <= 6){
			multiDatalist(td, row, column, "", keywordArray);
			addAdditionalData(td, row, column);
		}
		else if(column > 6 && row > 2){
			let optionArray = ["", "Eelistab", "Ei eelista", "Ei sobi"];
			makeSelectTableCell(td, activeTable, row, column, "sessionAvailability", optionArray, "true");
		}
	}
	else if(activeTable == "tableDefense"){
		if(column == 1 && row != 1){
			makeNormalTableCell(td, "left", "true", "");
		}
		else if(column == 2 && row != 1){
			let uniqueCode = "D";
			if(defenseCode < 9){
				defenseCode++;
				uniqueCode += "00" + defenseCode;
			} 
			else if(defenseCode < 99){
				defenseCode++;
				uniqueCode += "0" + defenseCode;
			}
			else {
				defenseCode++;
				uniqueCode += defenseCode;
			}
			makeNormalTableCell(td, "left", "false", uniqueCode);
		}
		else if(column == 3 && row != 1){
			let optionArray = ["Lahtine", "Kinnine"];
			makeSelectTableCell(td, activeTable, row, column, "defenseType", optionArray, "true");
		}
		else if(column == 4 && row != 1){
			let optionArray = ["Bakalaureus"];
			makeSelectTableCell(td, activeTable, row, column, "degree", optionArray, "true");
		}
		else if(column == 5 && row != 1){
			let input = document.createElement('input');
			let datalist = document.createElement('datalist');
			let datalistId = activeTable + '-' + row + '-' + column + '-datalist';
			datalist.id = datalistId;
			for(i = 0; i < authorArray.length; i++){
				let optionElement = document.createElement('option');
				optionElement.value = authorArray[i];
				datalist.appendChild(optionElement);
			}
			input.setAttribute('list', datalistId);
			input.appendChild(datalist);
			input.style.border = "0px";
			td.appendChild(input);
		}
		else if(column >= 6 && column <= 7 && row != 1){
			makeNormalTableCell(td, "left", "true", "");
		}
		else if(column == 8 && row != 1){
			makeNumberTableCell(td, activeTable, row, column, "roomCapacity", 20, 2, 99)
		}
		else if(column == 9 && row != 1){
			makeNumberTableCell(td, activeTable, row, column, "commissionSize", 3, 2, 99)
		}
	}
}

function makeNormalTableCell(td, textAlign, contentEditable, innerHtml){
	td.style.textAlign = textAlign;
	td.style.paddingLeft = "2px";
	td.style.paddingRight = "2px";
	td.contentEditable = contentEditable;
	td.innerHTML = innerHtml;
}

function makeSelectTableCell(td, activeTable, row, column, idAppend, optionArray, makeWide){
	let selectElement = document.createElement('select');
	let arrayLength = optionArray.length;
	let i;
	for(i = 0; i < arrayLength; i++){
		let selectOption = document.createElement('option');
		selectOption.value = optionArray[i];
		selectOption.innerHTML = optionArray[i];
		selectElement.appendChild(selectOption);
	}
	if(makeWide == "true"){
		selectElement.style.width = "100%";
	}
	selectElement.style.border = "0px";
	selectElement.name = activeTable + '-' + row + '-' + column + '-' + idAppend;
	selectElement.id = activeTable + '-' + row + '-' + column + '-' + idAppend;
	selectElement.className = "tableSelect";
	let cellHeight = td.style.height;
	selectElement.style.height = cellHeight;
	td.appendChild(selectElement);
}

function makeNumberTableCell(td, activeTable, row, column, idAppend, defaultValue, rowStart, maxLimit){
	let input = document.createElement('input');
	input.type = "number";
	input.min = "0";
	input.max = maxLimit;
	if(row == rowStart){
		input.value = defaultValue;
	}
	else {
		let lastSession = document.getElementById(activeTable + '-' + (row - 1) + '-' + column).childNodes[0].value;
		input.value = lastSession;
	}
	input.style.textAlign = "center";
	input.style.width = "93%";
	input.style.border = "0px";
	input.id = activeTable + '-' + row + '-' + column + '-' + idAppend;
	input.className = "tableNumber";
	let cellHeight = td.style.height;
	input.style.height = cellHeight;
	td.appendChild(input);
}

function multiDatalist(td, row, column, defaultValue, tableArray){
	let input = document.createElement('input');
	let datalist = document.createElement('datalist');
	let datalistId = activeTable + '-' + row + '-' + column + '-datalist';
	datalist.id = datalistId;
	let i;
	for(i = 0; i < tableArray.length; i++){
		let optionElement = document.createElement('option');
		optionElement.value = tableArray[i];
		datalist.appendChild(optionElement);
	}
	input.setAttribute('list', datalistId);
	input.appendChild(datalist);
	input.value = defaultValue;
	input.className = "tableDataList";
	let uniqueInputID = td.childElementCount;
	input.id = activeTable + '-' + row + '-' + column + '-input-' + uniqueInputID;
	let inputOuterHTML = input.outerHTML;
	if(!(activeTable == "tableAuthor" && column == 3)){
		input.style.textAlign = "center";
	}
	
	let cellHeight = td.style.height;
	input.style.borderLeft = "0px";
	input.style.borderTop = "0px";
	input.style.borderBottom = "0px";
	input.style.height = cellHeight;
	
	td.appendChild(input);
}

function addAdditionalData(td, row, column){
	let span = document.createElement('span');
	span.className = "plus";
	span.id = activeTable + "-" + row + "-" + column + "-span";
	span.innerHTML = "+";
	span.style.marginLeft = "3px";
	span.style.backgroundColor = "#a5a8ad";
	span.style.paddingLeft = "4px";
	span.style.paddingRight = "4px";
	span.style.cursor = "pointer";
	span.addEventListener('mouseenter', e => {
		span.style.backgroundColor = "#8f9296";
	})
	span.addEventListener('mouseleave', e => {
		span.style.backgroundColor = "#a5a8ad";
	})
	let spanClickHandler = function(span, arg1, arg2, arg3){
		return function() {
			span.remove();
			addTdInfo(arg1, arg2, arg3);
			};
	}
	span.onclick = spanClickHandler(span, td, row, column);
	td.appendChild(span);
}



function removeRow(){
	if(activeTable == null){
		errorMessage('Ei saa kustutada ridasid tabelist, mida pole olemas!', "deleteRow");	
	} else if(activeTableColumn == 0 && activeTableRow == 0){
		errorMessage('Ei saa kustutada tabeli rida, kui seda pole tehtud aktiivseks!', "deleteRow");
	} else {
		let tableRowId = activeTable + "-" + activeTableRow + "-" + activeTableColumn;
		let activeNode = document.getElementById(tableRowId);
		let previousNode = activeNode.parentNode.previousSibling.childNodes[0];
		activeNode.parentNode.remove();
		correctRows(parseInt(activeTableRow) - 1, activeTableColumn);
		activeTablePiece = "";
		activeTableRow = 0;
		activeTableColumn = 0;
	}
}

function addColumn(){
	let tableColumnValue = 1; //document.getElementById("tableColumn").value; -------------- see nupp on kaotatud
	let newColumns = parseInt(tableColumnValue, 10);
	if(activeTable == null){
		errorMessage('Ei saa lisada tabeli veergu tabelisse, mida pole olemas!', "addColumn");
	}
	else if(Number.isInteger(newColumns) || tableColumnValue == ""){
		let i, j, k, activeNode;
		let getActiveTable = document.getElementById(activeTable);
		let tbody = getActiveTable.childNodes;
		let currentRow;
		let newColumnsMax = 1;
		
		if(tableColumnValue != ""){
			newColumnsMax = newColumns;
		}
		
		for(k = 0; k < newColumnsMax; k++){
			let th = document.createElement('th');
			let row = "1";
			let column = tbody[0].childNodes[0].childNodes.length;
			let rows = tbody[0].childNodes.length + 1;
			let tdArray = [];
			
			let rowsStr;
			
			for(i = 0; i < rows-1; i++){
				getI = i+1;
				rowsStr = getI.toString();
				let td = document.createElement('td');
				td.className = "tableRowClass";
				td.id = activeTable.concat('-', rowsStr, '-', column);
				td.style.minWidth = "50px";
				td.style.height = "22px";
				addTdInfo(td, getI, column);
				tdArray.push(td);
			}
			for(j = 0; j < tdArray.length; j++){
				activeNode = tdArray[j];
				tbody[0].childNodes[j].appendChild(activeNode);
			}
		}
	}
	else {
		errorMessage('Tabeli veeruks sisestati "' + tableColumnValue + '", mis pole täisarvuline sisend!', "tableColumn");	
	}
}

function correctRows(currentRow, currentColumn){
	let tableRowID = activeTable + "-" + currentRow + "-" + currentColumn;
	let rowLength = document.getElementById(tableRowID).parentNode.childNodes.length;
	let columnLength = document.getElementById(tableRowID).parentNode.parentNode.childNodes.length;
	let i, j, getI, currentTableSlotID;
	for(i = currentRow; i < columnLength; i++){
		for(j = 0; j < rowLength; j++){
			getJ = parseInt(j)+1;
			getI = parseInt(i) + 1;
			currentTableSlotID = activeTable + "-" + getI + "-" + getJ;
			document.getElementById(tableRowID).parentNode.parentNode.childNodes[i].childNodes[j].id = currentTableSlotID;
		}
	}
}

function correctColumns(currentRow, currentColumn){
	let tableColumnID = activeTable + "-" + currentRow + "-" + currentColumn;
	let rowLength = document.getElementById(tableColumnID).parentNode.childNodes.length;
	let activeColumn = parseInt(currentColumn) + 1;
	let i, currentTableSlotID, temporaryID;
	for(i = activeColumn; i < rowLength+1; i++){
		currentTableSlotID = activeTable + "-" + currentRow + "-" + i;
		document.getElementById(tableColumnID).parentNode.childNodes[i-1].id = currentTableSlotID;
	}
	
}

function removeColumn(){
	if(activeTable == null){
		errorMessage('Ei saa kustutada veerge tabelist, mida pole olemas!', "deleteColumn");	
	} else if(activeTableColumn == 0 && activeTableRow == 0){
		errorMessage('Ei saa kustutada tabeli veergu, kui seda pole tehtud aktiivseks!', "deleteColumn");
	} else {
		let currentRow = 1;
		let getActiveTable = document.getElementById(activeTable);
		let tbody = getActiveTable.childNodes;
		let rows = tbody[0].childNodes.length;
		let i;
		for(i = 0; i < rows; i++){
			let tableRowId = activeTable + "-" + currentRow + "-" + activeTableColumn;
			let activeNode = document.getElementById(tableRowId);
			activeNode.remove();
			correctColumns(currentRow, parseInt(activeTableColumn) - 1);
			currentRow++;
		}
		activeTablePiece = "";
		activeTableRow = 0;
		activeTableColumn = 0;
	}
	
}

function validate(){
	let i, table, tableRowCount;
	if(document.getElementById("tabConfiguration") != null){
		table = document.getElementById("tableConfiguration");
		tableRowCount = table.rows.length;
		for(i = 2; i <= tableRowCount; i++){
			let weight = Number(document.getElementById("tableConfiguration-" + i + "-2").innerHTML);
			if(!isNaN(weight)){
				if(!Number.isInteger(weight)){
					errorMessage("Tabelis Configuration real " + i + " veerul 2 pole täisarvuline number, ta sisaldab komakohta.", "tableConfiguration-" + i + "-2");
				}
			} else {
				errorMessage("Tabelis Configuration real " + i + " veerul 2 pole täisarvuline number, ta sisaldab tähti või erilisi sümboleid.", "tableConfiguration-" + i + "-2");
			}
		}
	}
	if(document.getElementById("tabTimeslot") != null){
		table = document.getElementById("tableTimeslot");
		tableRowCount = table.rows.length;
		for(i = 2; i <= tableRowCount; i++){
			validateDate("tableTimeslot", i, 1);
			let timeStart = document.getElementById("tableTimeslot-" + i + "-2").innerHTML;
			let timeEnd = document.getElementById("tableTimeslot-" + i + "-3").innerHTML;
			validateTime("tableTimeslot", i, 2, 3, timeStart, timeEnd);
			let defenseType = document.getElementById("tableTimeslot-" + i + "-4").innerHTML;
			let session = document.getElementById("tableTimeslot-" + i + "-5").innerHTML;
			let keywords = document.getElementById("tableTimeslot-" + i + "-6").innerHTML;
			keywords = keywords.toLowerCase();
			if(defenseType == ""){
				if(session != ""){
					errorMessage("Tabelis Timeslot real " + i + " veerul 5 peab olema tühi lahter. Kui kaitsmise tüüp on tühi, siis sessioon peab olema ka tühi.", "tableTimeslot-" + i + "-5");
				}
				if(!keywords.includes(" vaheaeg") && !keywords.includes("vaheaeg,") && !keywords.includes(",vaheaeg ") && !keywords.includes(",vaheaeg,") && !keywords.includes("vaheaeg ")){
					errorMessage("Tabelis Timeslot real " + i + " veerul 6 peab sisaldama võtmesõna vaheaeg. Kui kaitsmise tüüp on tühi, siis võtmesõnades peab olema võtmesõna vaheaeg.", "tableTimeslot-" + i + "-6");
				}
			}
			else if(defenseType.toLowerCase() != "lahtine" && defenseType.toLowerCase() != "kinnine"){
				errorMessage("Tabelis Timeslot real " + i + " veerul 4 pole lahter tühi ega sisalda 'Lahtine' või 'Kinnine'.", "tableTimeslot-" + i + "-4");
			}
			let sessionNumber = Number(session);
			if(!isNaN(sessionNumber)){
				if(!Number.isInteger(sessionNumber)){
					errorMessage("Tabelis Timeslot real " + i + " veerul 5 peab olema täisarvuline number. Ta sisaldab komakohta.", "tableTimeslot-" + i + "-5");
				}
			} else {
				errorMessage("Tabelis Timeslot real " + i + " veerul 5 peab olema täisarvuline number. Ta sisaldab kas tähti või erilisi sümboleid.", "tableTimeslot-" + i + "-5");
			}
		}
	}
	if(document.getElementById("tabAuthor") != null){
		table = document.getElementById("tableAuthor");
		tableRowCount = table.rows.length;
		
		let tableColumnCount = table.rows[0].cells.length;
		for(i = 7; i <= tableColumnCount; i++){
			validateTimeslot("tableAuthor", i, tableRowCount);
			
			let date = document.getElementById("tableAuthor-1-" + i).innerHTML;
			let tableTimeslot = document.getElementById("tableTimeslot");
			tableTimeslotRowCount = tableTimeslot.rows.length;
			let foundDateMatch = false;
			for(j = 2; j <= tableTimeslotRowCount; j++){
				let timeslotDate = document.getElementById("tableTimeslot-" + j + "-1").innerHTML;
				if(date == timeslotDate){
					foundDateMatch = true;
					break;
				}
			}
			if(!foundDateMatch){
				errorMessage("Tabelis Author real 1 veerul " + i + " olev kuupäev " + date + " pole olemas Timeslot tabelis.", "tableAuthor-1-" + i);
			}
			validateDate("tableAuthor", 1, i);
			let time = document.getElementById("tableAuthor-2-" + i).innerHTML;
			let timeStart = time.substr(0, 5);
			let timeEnd = time.substr(6, 5);
			validateTime("tableAuthor", 2, i, i, timeStart, timeEnd)
			if(time.substr(5, 1) != "-"){
				errorMessage("Tabelis Author real 2 veerul " + i + " olev kellaaja vahemikul puudub märk '-'.", "tableAuthor-2-" + i);
			}
			if(time.length > 11){
				errorMessage("Tabelis Author real 2 veerul " + i + " olev kellaaja vahemik pole õiges formaadis. Formaat peab olema: hh:mm-hh:mm", "tableAuthor-2-" + i);
			}
			for(j = 3; j <= tableRowCount; j++){
				let preference = document.getElementById("tableAuthor-" + j + "-" + i).innerHTML;
				if(preference.toLowerCase() != "ei sobi" && preference.toLowerCase() != "ei eelista" && preference.toLowerCase() != "eelistab" && preference != ""){
					errorMessage("Tabelis Author real " + j + " veerul " + i + " olev eelistus pole 'ei sobi', 'ei eelista', 'eelistab' ega tühi. Ta on " + preference + ".", "tableAuthor-" + j + "-" + i);
				}
			}
			
		}
		
		for(i = 3; i <= tableRowCount; i++){
			let name = document.getElementById("tableAuthor-" + i + "-1").innerHTML;
			tableDefense = document.getElementById("tableDefense");
			tableDefenseRowCount = tableDefense.rows.length;
			let foundNameMatch = false;
			for(j = 2; j <= tableDefenseRowCount; j++){
				let nameDefense = document.getElementById("tableDefense-" + j + "-5").innerHTML;
				if(name == nameDefense){
					foundNameMatch = true;
					break;
				}
			}
			if(!foundNameMatch){
				errorMessage("Tabelis Author real " + i + " veerul 1 olev nimi " + name + " pole olemas tabelis Defense.", "tableAuthor-" + i + "-1");
			}
			let preconditions = document.getElementById("tableAuthor-" + i + "-2").innerHTML.toLowerCase();
			if(preconditions != "jah" && preconditions != "ei"){
				errorMessage("Tabelis Author real " + i + " veerul 2 olev eeldused peab olema kas 'jah' või 'ei'.	", "tableAuthor-" + i + "-2");
			}
			let supervisor = document.getElementById("tableAuthor-" + i + "-3").innerHTML;
			tableSupervisor = document.getElementById("tableSupervisor");
			tableSupervisorRowCount = tableSupervisor.rows.length;
			let count = 0;
			let countMax = 0;
			if(supervisor.includes(",")){
				countMax = (supervisor.match(/,/g) || []).length;		
			}
			let foundSupervisorMatch = false;
			for(j = 3; j <= tableSupervisorRowCount; j++){
				let nameSupervisor = document.getElementById("tableSupervisor-" + j + "-1").innerHTML;
				if(supervisor.includes(",")){
					if(supervisor.search(nameSupervisor)){
						count++;
						if(count == countMax+1){
							foundSupervisorMatch = true;
							break;
						}
					}
				} else {
					if(supervisor.includes(nameSupervisor)){
						foundSupervisorMatch = true;
						break;
					}
				}
			}
			if(!foundSupervisorMatch){
				errorMessage("Tabelis Author real " + i + " veerul 3 olev juhendaja " + supervisor + " pole olemas tabelis Supervisor.", "tableAuthor-" + i + "-3");
			}
			validateKeyWords("tableAuthor", i, 4);
			validateKeyWords("tableAuthor", i, 5);
			validateKeyWords("tableAuthor", i, 6);
		}
	}
	if(document.getElementById("tabSupervisor") != null){
		table = document.getElementById("tableSupervisor");
		tableRowCount = table.rows.length;
		let tableColumnCount = table.rows[0].cells.length;
		for(i = 6; i <= tableColumnCount; i++){
			let date = document.getElementById("tableSupervisor-1-" + i).innerHTML;
			let tableTimeslot = document.getElementById("tableTimeslot");
			tableTimeslotRowCount = tableTimeslot.rows.length;
			let foundDateMatch = false;
			for(j = 2; j <= tableTimeslotRowCount; j++){
				let timeslotDate = document.getElementById("tableTimeslot-" + j + "-1").innerHTML;
				if(date == timeslotDate){
					foundDateMatch = true;
					break;
				}
			}
			if(!foundDateMatch){
				errorMessage("Tabelis Supervisor real 1 veerul " + i + " olev kuupäev " + date + " pole olemas Timeslot tabelis.", "tableSupervisor-1-" + i);
			}
			validateDate("tableSupervisor", 1, i);
			let time = document.getElementById("tableSupervisor-2-" + i).innerHTML;
			let timeStart = time.substr(0, 5);
			let timeEnd = time.substr(6, 5);
			validateTime("tableSupervisor", 2, i, i, timeStart, timeEnd)
			if(time.substr(5, 1) != "-"){
				errorMessage("Tabelis Supervisor real 2 veerul " + i + " olev kellaaja vahemikul puudub märk '-'.", "tableSupervisor-2-" + i);
			}
			if(time.length > 11){
				errorMessage("Tabelis Supervisor real 2 veerul " + i + " olev kellaaja vahemik pole õiges formaadis. Formaat peab olema: hh:mm-hh:mm", "tableSupervisor-2-" + i);
			}
			for(j = 3; j <= tableRowCount; j++){
				let preference = document.getElementById("tableSupervisor-" + j + "-" + i).innerHTML;
				if(preference.toLowerCase() != "ei sobi" && preference.toLowerCase() != "ei eelista" && preference.toLowerCase() != "eelistab" && preference != ""){
					errorMessage("Tabelis Supervisor real " + j + " veerul " + i + " olev eelistus pole 'ei sobi', 'ei eelista', 'eelistab' ega tühi. Ta on " + preference + ".", "tableSupervisor-" + j + "-" + i);
				}
			}
			
		}
		for(i = 3; i <= tableRowCount; i++){
			let supervisor = document.getElementById("tableSupervisor-" + i + "-1").innerHTML;
			tableAuthor = document.getElementById("tableAuthor");
			tableAuthorRowCount = tableAuthor.rows.length;
			let foundSupervisorMatch = false;
			for(j = 3; j <= tableAuthorRowCount; j++){
				let nameSupervisor = document.getElementById("tableAuthor-" + j + "-3").innerHTML;
				if(nameSupervisor.includes(supervisor)){
					foundSupervisorMatch = true;
					break;
				}			
			}
			if(!foundSupervisorMatch){
				errorMessage("Tabelis Supervisor real " + i + " veerul 1 olev juhendaja " + supervisor + " pole olemas tabelis Author.", "tableSupervisor-" + i + "-1");
			}
			let role = document.getElementById("tableSupervisor-" + i + "-2").innerHTML;
			if(role.toLowerCase() != "peajuhendaja" && role.toLowerCase() != "kaasjuhendaja"){
				errorMessage("Tabelis Supervisor real " + i + " veerul 2 olev roll ei ole 'peajuhendaja' ega 'kaasjuhendaja'. Ta on " + role + ".", "tableSupervisor-" + i + "-2");
			}
			validateKeyWords("tableSupervisor", i, 3);
			validateKeyWords("tableSupervisor", i, 4);
			validateKeyWords("tableSupervisor", i, 5);
		}
	}
	if(document.getElementById("tabCommitee") != null){
		table = document.getElementById("tableCommitee");
		tableRowCount = table.rows.length;
		let tableColumnCount = table.rows[0].cells.length;
		for(i = 7; i <= tableColumnCount; i++){
			let date = document.getElementById("tableCommitee-1-" + i).innerHTML;
			let tableTimeslot = document.getElementById("tableTimeslot");
			tableTimeslotRowCount = tableTimeslot.rows.length;
			let foundDateMatch = false;
			for(j = 2; j <= tableTimeslotRowCount; j++){
				let timeslotDate = document.getElementById("tableTimeslot-" + j + "-1").innerHTML;
				if(date == timeslotDate){
					foundDateMatch = true;
					break;
				}
			}
			if(!foundDateMatch){
				errorMessage("Tabelis Commitee real 1 veerul " + i + " olev kuupäev " + date + " pole olemas Timeslot tabelis.", "tableCommitee-1-" + i);
			}
			validateDate("tableCommitee", 1, i);
			let time = document.getElementById("tableCommitee-2-" + i).innerHTML;
			let timeStart = time.substr(0, 5);
			let timeEnd = time.substr(6, 5);
			validateTime("tableCommitee", 2, i, i, timeStart, timeEnd)
			if(time.substr(5, 1) != "-"){
				errorMessage("Tabelis Commitee real 2 veerul " + i + " olev kellaaja vahemikul puudub märk '-'.", "tableCommitee-2-" + i);
			}
			if(time.length > 11){
				errorMessage("Tabelis Commitee real 2 veerul " + i + " olev kellaaja vahemik pole õiges formaadis. Formaat peab olema: hh:mm-hh:mm", "tableCommitee-2-" + i);
			}
			for(j = 3; j <= tableRowCount; j++){
				let preference = document.getElementById("tableCommitee-" + j + "-" + i).innerHTML;
				if(preference.toLowerCase() != "ei sobi" && preference.toLowerCase() != "ei eelista" && preference.toLowerCase() != "eelistab" && preference != ""){
					errorMessage("Tabelis Commitee real " + j + " veerul " + i + " olev eelistus pole 'ei sobi', 'ei eelista', 'eelistab' ega tühi. Ta on " + preference + ".", "tableCommitee-" + j + "-" + i);
				}
			}
			
		}
		for(i = 3; i <= tableRowCount; i++){
			let degree = document.getElementById("tableCommitee-" + i + "-2").innerHTML;
			if(degree.toLowerCase() != "doktor" && degree.toLowerCase() != "magister"){
				errorMessage("Tabelis Commitee real " + i + " veerul 2 olev kraad ei ole 'Doktor' ega 'Magister'. Ta on " + degree + ".", "tableCommitee-" + i + "-2");
			}
			let chairman = document.getElementById("tableCommitee-" + i + "-3").innerHTML;
			if(chairman.toLowerCase() != "esimees" && chairman.toLowerCase() != "aseesimees" && chairman.toLowerCase() != "ei"){
				errorMessage("Tabelis Commitee real " + i + " veerul 3 olev esimees pole kirjas 'esimees', 'aseesimees' ega 'ei'. Ta on " + chairman + ".", "tableCommitee-" + i + "-3");
			}
			validateKeyWords("tableCommitee", i, 4);
			validateKeyWords("tableCommitee", i, 5);
			validateKeyWords("tableCommitee", i, 6);
		}
	}
	if(document.getElementById("tabDefense") != null){
		table = document.getElementById("tableDefense");
		tableRowCount = table.rows.length;
		let codeArray = [];
		for(i = 2; i <= tableRowCount; i++){
			let code = document.getElementById("tableDefense-" + i + "-1").innerHTML;
			if(code.length == 4){
				if(code.includes("D")){
					let codeNumber = Number(code.substr(1));
					if(!isNaN(codeNumber)){
						if(Number.isInteger(codeNumber)){
							if(!codeArray.includes(code)){
								codeArray.push(code);
							} else {
								errorMessage("Tabelis Defense real " + i + " veerul 1 olev kood pole unikaalne.", "tableDefense-" + i + "-1");
							}
						} else {
							errorMessage("Tabelis Defense real " + i + " veerul 1 olev kood sisaldab punkti.", "tableDefense-" + i + "-1");
						}
					} else {
						errorMessage("Tabelis Defense real " + i + " veerul 1 olev koodi viimased 3 märki pole numbrid.", "tableDefense-" + i + "-1");
					}
				} else {
					errorMessage("Tabelis Defense real " + i + " veerul 1 olev kood ei sisalda tähte 'D'.", "tableDefense-" + i + "-1");
				}
			} else {
				errorMessage("Tabelis Defense real " + i + " veerul 1 olev kood pole 4 märki pikk.", "tableDefense-" + i + "-1");
			}
			validateTitle("tableDefense", i, 2);
			let defenseType = document.getElementById("tableDefense-" + i + "-3").innerHTML;
			if(defenseType.toLowerCase() != "lahtine" && defenseType.toLowerCase() != "kinnine"){
				errorMessage("Tabelis Defense real " + i + " veerul 3 olev kaitsmise tüüp pole 'kinnine' ega 'lahtine'. Te kirjutasite " + defenseType + ".", "tableDefense-" + i + "-3")
			}
			let defenseDegree = document.getElementById("tableDefense-" + i + "-4").innerHTML;
			if(defenseDegree.toLowerCase() != "bakalaureus"){
				errorMessage("Tabelis Defense real " + i + " veerul 3 olev kaitsmise kraad pole 'bakalaureus'. Te kirjutasite " + defenseType + ".", "tableDefense-" + i + "-3")
			}
			validateTitle("tableDefense", i, 6);
			let defender = document.getElementById("tableDefense-" + i + "-5").innerHTML;
			tableAuthor = document.getElementById("tableAuthor");
			tableAuthorRowCount = tableAuthor.rows.length;
			let foundNameMatch = false;
			for(j = 3; j <= tableAuthorRowCount; j++){
				let nameAuthor = document.getElementById("tableAuthor-" + j + "-1").innerHTML;
				if(defender == nameAuthor){
					foundNameMatch = true;
					break;
				}
			}
			if(!foundNameMatch){
				errorMessage("Tabelis Defense real " + i + " veerul 5 olev nimi " + defender + " pole olemas tabelis Author.", "tableDefense-" + i + "-5");
			}
			let roomSize = Number(document.getElementById("tableDefense-" + i + "-8").innerHTML);
			if(!isNaN(roomSize)){
				if(!Number.isInteger(roomSize)){
					errorMessage("Tabelis Defense real " + i + " veerul 8 olev ruumi suurus pole täisarvuline number.", "tableDefense-" + i + "-8");
				}
			} else {
				errorMessage("Tabelis Defense real " + i + " veerul 8 olev ruumi suurus sisaldab tähti või erilisi sümboleid.", "tableDefense-" + i + "-8");
			}
			let commiteeSize = Number(document.getElementById("tableDefense-" + i + "-9").innerHTML);
			if(!isNaN(commiteeSize)){
				if(!Number.isInteger(commiteeSize)){
					errorMessage("Tabelis Defense real " + i + " veerul 9 olev komisjoni suurus pole täisarvuline number.", "tableDefense-" + i + "-9");
				}
			} else {
				errorMessage("Tabelis Defense real " + i + " veerul 8 olev komisjoni suurus sisaldab täthi või erilisi sümboleid.", "tableDefense-" + i + "-9");
			}
		}
	}
}

function validateTitle(table, row, column){
	let tableName = table.substr(5);
	let keywords = document.getElementById(table + "-" + row + "-" + column).innerHTML;
	let specialSymbols = ["<", ">"];
	let message = "";
	for(j = 0; j < specialSymbols.length; j++){
		if(keywords.includes(specialSymbols[j])){
			message += specialSymbols[j] + " ";
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + column + " olev sümbol " + message + " pole lubatud märksõnades kasutada.", table + "-" + row + "-" + column);
		}
	}
}

function validateKeyWords(table, row, column){
	let tableName = table.substr(5);
	let keywords = document.getElementById(table + "-" + row + "-" + column).innerHTML;
	let specialSymbols = ["%", "(", ")", ":", ";", "[", "]", "{", "}", "!", "/", "<", ">", "+", "-", "*"];
	let message = "";
	for(j = 0; j < specialSymbols.length; j++){
		if(keywords.includes(specialSymbols[j])){
			message += specialSymbols[j] + " ";
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + column + " olev sümbol " + message + " pole lubatud märksõnades kasutada.", table + "-" + row + "-" + column);
		}
	}
}

function validateTimeslot(table, column, tableRowCount){
	let tableName = table.substr(5);
	let date = document.getElementById(table + "-1-" + column).innerHTML;
	let tableTimeslot = document.getElementById("tableTimeslot");
	tableTimeslotRowCount = tableTimeslot.rows.length;
	let foundDateMatch = false;
	for(j = 2; j <= tableTimeslotRowCount; j++){
		let timeslotDate = document.getElementById("tableTimeslot-" + j + "-1").innerHTML;
		if(date == timeslotDate){
			foundDateMatch = true;
			break;
		}
	}
	if(!foundDateMatch){
		errorMessage("Tabelis " + tableName + " real 1 veerul " + column + " olev kuupäev " + date + " pole olemas Timeslot tabelis.", table + "-1-" + column);
	}
	validateDate(table, 1, column);
	let time = document.getElementById(table + "-2-" + column).innerHTML;
	let timeStart = time.substr(0, 5);
	let timeEnd = time.substr(6, 5);
	validateTime(table, 2, i, i, timeStart, timeEnd)
	if(time.substr(5, 1) != "-"){
		errorMessage("Tabelis " + tableName + " real 2 veerul " + column + " olev kellaaja vahemikul puudub märk '-'.", table + "-2-" + column);
	}
	if(time.length > 11){
		errorMessage("Tabelis " + tableName + " real 2 veerul " + column + " olev kellaaja vahemik pole õiges formaadis. Formaat peab olema: hh:mm-hh:mm", table + "-2-" + column);
	}
	for(j = 3; j <= tableRowCount; j++){
		let preference = document.getElementById(table + "-" + j + "-" + column).innerHTML;
		if(preference.toLowerCase() != "ei sobi" && preference.toLowerCase() != "ei eelista" && preference.toLowerCase() != "eelistab" && preference != ""){
			errorMessage("Tabelis " + tableName + " real " + j + " veerul " + column + " olev eelistus pole 'ei sobi', 'ei eelista', 'eelistab' ega tühi. Ta on " + preference + ".", table + "-" + j + "-" + column);
		}
	}
}

function validateDate(table, row, column){
	let tableName = table.substr(5);
	let date = document.getElementById(table + "-" + row + "-" + column).innerHTML;
	let day = Number(date.substr(0, 2));
	if(!isNaN(day)){
		if(day > 31){
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + column + " on liiga suur kuupäev, ei tohi ületada 31 päeva.", table + "-" + row + "-" + column);
		}
	} else {
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + column + " pole täisarvuline päeva number, ta sisaldab tähti või erilisi sümboleid.", table + "-" + row + "-" + column);
	}
	let dot1 = date.substr(2, 1);
	let dot2 = date.substr(5, 1);
	if(dot1 != "." || dot2 != "."){
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + column + " pole kuupäev õiges formaadis dd.mm.yyyy .", table + "-" + row + "-" + column);
	}
	let month = Number(date.substr(3, 2));
	if(!isNaN(month)){
		if(month > 12){
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + column + " on liiga suur kuupäev, ei tohi ületada 12 kuud.", table + "-" + row + "-" + column)
		}
	} else {
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + column + " pole täisarvuline kuu number, ta sisaldab tähti või erilisi sümboleid.", table + "-" + row + "-" + column);
	}
	let year = Number(date.substr(6));
	if(!isNaN(year)){
		if(year > 9999){
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + column + " on liiga suur aasta, ei tohi sisaldada rohkem kui 4 numbrit.", table + "-" + row + "-" + column);
		}
		if(!Number.isInteger(year)){
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + column + " pole täisarvuline aasta number, ta sisaldab komakohta.", table + "-" + row + "-" + column);
		}
	} else {
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + column + " pole täisarvuline aasta number, ta sisaldab tähti või erilisi sümboleid.", table + "-" + row + "-" + column);
	}
}

function validateTime(table, row, columnStart, columnEnd, timeStart, timeEnd){
	let tableName = table.substr(5);
	let timeStartHour = Number(timeStart.substr(0, 2));
	let timeStartMinute = Number(timeStart.substr(3, 2));
	let timeEndHour = Number(timeEnd.substr(0, 2));
	let timeEndMinute = Number(timeEnd.substr(3, 2));
	let timeStartColon = timeStart.substr(2, 1);
	let timeEndColon = timeEnd.substr(2, 1);
	let timeStartInMinutes = 0;
	let timeEndInMinutes = 0;
	if(timeStartColon != ":"){
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnStart + " on vale formaat, ta ei sisalda koolonit. Formaat on hh:mm .", table + "-" + row + "-" + columnStart);
	}
	if(timeEndColon != ":"){
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnEnd + " on vale formaat, ta ei sisalda koolonit. Formaat on hh:mm .", table + "-" + row + "-" + columnEnd);
	}
	if(timeStart.substr(0, 2).includes(".")){
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnStart + " tund sisaldab märki punkt.", table + "-" + row + "-" + columnStart);
	}
	if(timeStart.substr(3, 2).includes(".")){
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnStart + " minut sisaldab märki punkt.", table + "-" + row + "-" + columnStart);
	}
	if(timeEnd.substr(0, 2).includes(".")){
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnEnd + " tund sisaldab märki punkt.", table + "-" + row + "-" + columnEnd);
	}
	if(timeEnd.substr(3, 2).includes(".")){
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnEnd + " minut sisaldab märki punkt.", table + "-" + row + "-" + columnEnd);
	}
	if(!isNaN(timeStartHour)){
		if(timeStartHour > 24){
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnStart + " on liiga suur arv, ei tohi ületada 24 tundi.", table + "-" + row + "-" + columnEnd);
		}
	} else {
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnStart + " pole täisarvuline tunni number, ta sisaldab tähti või erilisi sümboleid.", table + "-" + row + "-" + columnStart);
	}
	if(!isNaN(timeStartMinute)){
		if(timeStartMinute > 60){
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnStart + " on liiga suur arv, ei tohi ületada 60 minutit.", table + "-" + row + "-" + columnStart);
		}
	} else {
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnStart + " pole täisarvuline minuti number, ta sisaldab tähti või erilisi sümboleid.", table + "-" + row + "-" + columnStart);
	}
	if(!isNaN(timeEndHour)){
		if(timeEndHour > 24){
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnEnd + " on liiga suur arv, ei tohi ületada 24 tundi.", table + "-" + row + "-" + columnEnd);
		}
	} else {
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnEnd + " pole täisarvuline tunni number, ta sisaldab tähti või erilisi sümboleid.", table + "-" + row + "-" + columnEnd);
	}
	if(!isNaN(timeEndMinute)){
		if(timeEndMinute > 60){
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnEnd + " on liiga suur arv, ei tohi ületada 60 minutit.", table + "-" + row + "-" + columnEnd);
		}
	} else {
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnEnd + " pole täisarvuline minuti number, ta sisaldab tähti või erilisi sümboleid.", table + "-" + row + "-" + columnEnd);
	}
	if(!isNaN(timeStartHour) || !isNaN(timeStartMinute) || !isNaN(timeEndHour) || !isNaN(timeEndMinute)){
		timeStartInMinutes += (60 * timeStartHour);
		timeStartInMinutes += timeStartMinute;
		timeEndInMinutes += (60 * timeEndHour);
		timeEndInMinutes += timeEndMinute;
		if(timeStartInMinutes > timeEndInMinutes){
			errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnEnd + " on kellaaeg väiksem kui kaitsmise kella algus.", table + "-" + row + "-" + columnEnd);
		}
	}
	if(timeStart.length > 5){
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnStart + " on liiga suur sisend, formaat peab olema hh:mm .", table + "-" + row + "-" + columnStart);
	}
	if(timeEnd.length > 5){
		errorMessage("Tabelis " + tableName + " real " + row + " veerul " + columnEnd + " on liiga suur sisend, formaat peab olema hh:mm .", table + "-" + row + "-" + columnEnd);
	}
}

function addKeywordsToArray(nodeCount, rowStart, columnStart, columnEnd, tableName){
	let i, k, j;
	for(i = rowStart; i <= nodeCount; i++){
		for(k = columnStart; k <= columnEnd; k++){
			let keyword = "";
			let keywords = document.getElementById(tableName + '-' + i + '-' + k).childElementCount;
			for(j = 0; j < keywords-1; j++){
				keyword = document.getElementById(tableName + '-' + i + '-' + k).childNodes[j].value;
				if(!keywordArray.includes(keyword)){
					keywordArray.push(keyword);
				}
			}
		}
	}
}

function updateKeywordDatalists(nodeCount, rowStart, columnStart, columnEnd, tableName){
	let j, i, k;
	for(j = rowStart; j <= nodeCount; j++){
		for(i = columnStart; i <= columnEnd; i++){
			if(document.getElementById(tableName + '-' + j + '-' + i).childElementCount > 0){
				let dataCell = document.getElementById(tableName + '-' + j + '-' + i);
				let dataCellElementsLength = dataCell.childElementCount;
				let dataCellElements = dataCell.childNodes;
				let defaultValues = [];
				for(k = 0; k < (dataCellElementsLength-1); k++){
					defaultValues[k] = dataCell.childNodes[0].value;
					dataCell.childNodes[0].remove();
				}
				dataCell.childNodes[0].remove();
				for(k = 0; k < (dataCellElementsLength-1); k++){
					multiDatalist(dataCell, j ,i, defaultValues[k], keywordArray);
				}
				addAdditionalData(dataCell, j, i);
			}
		}
	}
}

window.onclick = function(event){
	let i, j, k;
	if(event.target.closest('#spanKeel')){
	
	}
	
	if(event.target.matches('.errorMessage')){
		let errorID = event.target.id;
		let targetArrayIdIndex = errorID.indexOf("-");
		let targetArrayId = errorID.substring(targetArrayIdIndex+1);
		let errorMessageTargetId = errorMessageTarget[targetArrayId];
		let errorDOM = document.getElementById(errorMessageTargetId);
		for(i = 0; i < errorMessageTarget.length; i++){
			document.getElementById(errorMessageTarget[i]).style.backgroundColor = "white";
		}
		errorDOM.style.backgroundColor = "#f07d5d";
	} else {
		let i;
		for(i = 0; i < errorMessageTarget.length; i++){
			document.getElementById(errorMessageTarget[i]).style.backgroundColor = "white";
		}
	}
	
	if(event.target.matches(".tableRowClass") || (event.target.matches(".tableDataList") && !event.target.matches(currentSlot))){
		currentSlot = "#" + event.target.id;
		let nodesTimeslot = document.getElementById("tableTimeslot-1-1").parentNode.parentNode.childElementCount;
		let nodesAuthor = document.getElementById("tableAuthor-1-1").parentNode.parentNode.childElementCount;
		let nodesSupervisor = document.getElementById("tableSupervisor-1-1").parentNode.parentNode.childElementCount;
		let nodesCommitee = document.getElementById("tableCommitee-1-1").parentNode.parentNode.childElementCount;
		keywordArray = [];
		addKeywordsToArray(nodesTimeslot, 2, 6, 6, 'tableTimeslot');
		addKeywordsToArray(nodesAuthor, 3, 4, 6, 'tableAuthor');
		addKeywordsToArray(nodesSupervisor, 3, 3, 5, 'tableSupervisor');
		addKeywordsToArray(nodesCommitee, 3, 4, 6, 'tableCommitee');
		updateKeywordDatalists(nodesTimeslot, 2, 6, 6, 'tableTimeslot', td);
		updateKeywordDatalists(nodesAuthor, 3, 4, 6, 'tableAuthor');
		updateKeywordDatalists(nodesSupervisor, 3, 3, 5, 'tableSupervisor', td);
		updateKeywordDatalists(nodesCommitee, 3, 4, 6, 'tableCommitee', td);
		let input = event.target.id;
		let datalist = input.substring(0, (input.length - 5)) + "datalist";
		document.getElementById(event.target.id).focus();
		document.getElementById(event.target.id).click();
	}
	
	// Kui vajutatakse Autori tabeli peale.
	if(event.target.matches('#tabAuthor')){
		document.getElementById("timeslotCustomCreate").style.visibility = "hidden";
		let nodesSupervisor = document.getElementById("tableSupervisor-1-1").parentNode.parentNode.childElementCount;
		supervisorArray = [];
		
		for(i = 3; i <= nodesSupervisor; i++){
			let supervisorName = document.getElementById('tableSupervisor-' + i + '-1').innerHTML;
			if(!supervisorArray.includes(supervisorName)){
				supervisorArray.push(supervisorName);
			}
		}
		let nodesAuthor = document.getElementById("tableAuthor-1-3").parentNode.parentNode;
		let nodesAuthorChildCount = nodesAuthor.childElementCount;
		for(j = 3; j <= nodesAuthorChildCount; j++){
			if(document.getElementById('tableAuthor-' + j + '-3').childElementCount > 0){
				let td = document.getElementById("tableAuthor-" + j + "-3");
				let tdElementsLength = td.childElementCount;
				let tdElements = td.childNodes;
				let defaultValues = [];
				let k;
				for(k = 0; k < (tdElementsLength-1); k++){
					defaultValues[k] = td.childNodes[0].value;
					td.childNodes[0].remove();
				}
				td.childNodes[0].remove();
				for(k = 0; k < (tdElementsLength-1); k++){
					multiDatalist(td, j ,3, defaultValues[k], supervisorArray);
				}
				addAdditionalData(td, j, 3);
			}
		}
		let nodeTimeslot = document.getElementById("tableTimeslot-1-1").parentNode.parentNode;
		let nodeTimeslotChildCount = nodeTimeslot.childElementCount;
		let columnChangedCount = 0;
		let authorTimeslotCount = nodesAuthor.childNodes[0].childElementCount - 6;
		
		for(i = 2; i <= nodeTimeslotChildCount; i++){
			let timeslotDate = nodeTimeslot.childNodes[i-1].childNodes[0].innerHTML;
			let timeslotStartTime = nodeTimeslot.childNodes[i-1].childNodes[1].innerHTML;
			let timeslotEndTime = nodeTimeslot.childNodes[i-1].childNodes[2].innerHTML;
			let timeslotDefenseType = nodeTimeslot.childNodes[i-1].childNodes[3].childNodes[0].value;
			let timeslotTime = timeslotStartTime + "-" + timeslotEndTime;
			if(timeslotDefenseType == "Lahtine" || timeslotDefenseType == "Kinnine"){
				columnChangedCount++;
				if(columnChangedCount > authorTimeslotCount){
					activeTable = "tableAuthor";
					addColumn();
				}
				nodesAuthor.childNodes[0].childNodes[5 + columnChangedCount].innerHTML = timeslotDate;
				nodesAuthor.childNodes[1].childNodes[5 + columnChangedCount].innerHTML = timeslotTime;
			}
		}
	}
	if(event.target.matches('#tabSupervisor')){
		document.getElementById("timeslotCustomCreate").style.visibility = "hidden";
		let nodesSupervisor = document.getElementById("tableSupervisor-1-3").parentNode.parentNode;
		let nodesSupervisorChildCount = nodesSupervisor.childElementCount;
		let nodeTimeslot = document.getElementById("tableTimeslot-1-1").parentNode.parentNode;
		let nodeTimeslotChildCount = nodeTimeslot.childElementCount;
		let columnChangedCount = 0;
		let supervisorTimeslotCount = nodesSupervisor.childNodes[0].childElementCount - 5;
		let i;
		for(i = 2; i <= nodeTimeslotChildCount; i++){
			let timeslotDate = nodeTimeslot.childNodes[i-1].childNodes[0].innerHTML;
			let timeslotStartTime = nodeTimeslot.childNodes[i-1].childNodes[1].innerHTML;
			let timeslotEndTime = nodeTimeslot.childNodes[i-1].childNodes[2].innerHTML;
			let timeslotDefenseType = nodeTimeslot.childNodes[i-1].childNodes[3].childNodes[0].value;
			let timeslotTime = timeslotStartTime + "-" + timeslotEndTime;
			if(timeslotDefenseType == "Lahtine" || timeslotDefenseType == "Kinnine"){
				columnChangedCount++;
				if(columnChangedCount > supervisorTimeslotCount){
					activeTable = "tableSupervisor";
					addColumn();
				}
				nodesSupervisor.childNodes[0].childNodes[4 + columnChangedCount].innerHTML = timeslotDate;
				nodesSupervisor.childNodes[1].childNodes[4 + columnChangedCount].innerHTML = timeslotTime;
			}
		}
	}
	if(event.target.matches('#tabCommitee')){
		document.getElementById("timeslotCustomCreate").style.visibility = "hidden";
		let nodesSupervisor = document.getElementById("tableCommitee-1-3").parentNode.parentNode;
		let nodesSupervisorChildCount = nodesSupervisor.childElementCount;
		let nodeTimeslot = document.getElementById("tableTimeslot-1-1").parentNode.parentNode;
		let nodeTimeslotChildCount = nodeTimeslot.childElementCount;
		let columnChangedCount = 0;
		let supervisorTimeslotCount = nodesSupervisor.childNodes[0].childElementCount - 6;
		let i;
		for(i = 2; i <= nodeTimeslotChildCount; i++){
			let timeslotDate = nodeTimeslot.childNodes[i-1].childNodes[0].innerHTML;
			let timeslotStartTime = nodeTimeslot.childNodes[i-1].childNodes[1].innerHTML;
			let timeslotEndTime = nodeTimeslot.childNodes[i-1].childNodes[2].innerHTML;
			let timeslotDefenseType = nodeTimeslot.childNodes[i-1].childNodes[3].childNodes[0].value;
			let timeslotTime = timeslotStartTime + "-" + timeslotEndTime;
			if(timeslotDefenseType == "Lahtine" || timeslotDefenseType == "Kinnine"){
				columnChangedCount++;
				if(columnChangedCount > supervisorTimeslotCount){
					activeTable = "tableCommitee";
					addColumn();
				}
				nodesSupervisor.childNodes[0].childNodes[5 + columnChangedCount].innerHTML = timeslotDate;
				nodesSupervisor.childNodes[1].childNodes[5 + columnChangedCount].innerHTML = timeslotTime;
			}
		}
	}
	if(event.target.matches('#tabTimeslot')){
		document.getElementById("timeslotCustomCreate").style.visibility = "visible";
	}
	if(event.target.matches('#tabPlanned Data')){
		document.getElementById("timeslotCustomCreate").style.visibility = "hidden";
	}
	if(event.target.matches('#tabDefense')){
		document.getElementById("timeslotCustomCreate").style.visibility = "hidden";
		let nodesAuthor = document.getElementById("tableAuthor-1-1").parentNode.parentNode.childElementCount;
		authorArray = [];
		let i, j;
		for(i = 3; i <= nodesAuthor; i++){
			let authorName = document.getElementById('tableAuthor-' + i + '-1').innerHTML;
			authorArray.push(authorName);
		}
		let nodesDefense = document.getElementById("tableDefense-1-5").parentNode.parentNode.childElementCount;
		for(j = 2; j <= nodesDefense; j++){
			if(document.getElementById('tableDefense-' + j + '-5').childElementCount > 0){
				let td = document.getElementById("tableDefense-" + j + "-5");
				let defaultValue = td.childNodes[0].value;
				td.removeChild(td.firstChild);
				addTdInfo(td, j, 5);
				td.childNodes[0].value = defaultValue;
			}
		}
	}
	if(!event.target.closest('.menuButtonExtra')) {
		let dropdowns = document.getElementsByClassName("dropdown-content2");
		for(i = 0; i < dropdowns.length; i++){
			let openDropdown = dropdowns[i];
			if(openDropdown.classList.contains('show')){
				openDropdown.classList.remove('show');
			}
		}
		
		if(event.target.matches('#tableRows') || event.target.matches('.tab') || event.target.matches('.emptySpace')){
			activeTableRow = 0;
			activeTableColumn = 0;
			if(activeTablePiece != ""){
				document.getElementById(activeTablePiece).style.backgroundColor = "white";
			}
		}
		
		if(event.target.className.includes("tableRowClass")){
			let tableInfo = event.target.id;
			let rowIndex = tableInfo.indexOf("-");
			let tableInfoBack = tableInfo.substring(rowIndex+1);
			let columnIndex = tableInfoBack.indexOf("-");
			activeTableRow = tableInfoBack.substring(0, columnIndex);
			activeTableColumn = tableInfoBack.substring(columnIndex+1);
			if(activeTablePiece != ""){
				document.getElementById(activeTablePiece).style.backgroundColor = "white";
			}
			document.getElementById(tableInfo).style.backgroundColor = "#e6d8c3";
			activeTablePiece = tableInfo;
		} else if(event.target.className.includes("tableSelect") || event.target.className.includes("tableNumber") || event.target.className.includes("tableDataList")){
			let tableInfo = event.target.id;
			let rowIndex = tableInfo.indexOf("-");
			let tableInfoBack = tableInfo.substring(rowIndex+1);
			let columnIndex = tableInfoBack.indexOf("-");
			activeTableRow = tableInfoBack.substring(0, columnIndex);
			tableInfoBack = tableInfoBack.substring(columnIndex+1);
			let typeIndex = tableInfoBack.indexOf("-");
			activeTableColumn = tableInfoBack.substring(0, typeIndex);
			if(activeTablePiece != "" && activeTablePiece != null){
				document.getElementById(activeTablePiece).style.backgroundColor = "white";
			}
			document.getElementById(tableInfo).style.backgroundColor = "#e6d8c3";
			activeTablePiece = tableInfo;
		}
		
	}
}

function tableareaScroll(){
	let el = document.getElementById("tableRows");
	let rowNum = document.getElementById("rowCounter");
	let x = el.scrollLeft;
	if(x >= 100){
		rowNum.style.visibility = "visible";
		if(activeTable == "tableDefense"){
			rowNum.style.width = "20%";
			el.style.width = "85%";
		} else {
			rowNum.style.width = "10%";
			el.style.width = "90%";
		}
	} else if(x < 100){
		rowNum.style.visibility = "hidden";
		rowNum.style.width = "2.45%";
		el.style.width = "97.55%";
	}
	console.log(activeTable);
	let table = document.getElementById(activeTable);
	let row = document.getElementById(activeTable + "-rows");
	let tableLength = table.childNodes[0].childElementCount;
	let i;
	for(i = 0; i < tableLength; i++){
		let data = table.childNodes[0].childNodes[i].childNodes[0].innerHTML;
		row.childNodes[0].childNodes[i].childNodes[0].innerHTML = data;
	}
	console.log(tableLength);
	let elementCount = "";
	let y = el.scrollTop;
	if(y != oldY){
		rowNum.scrollTop = y;
		oldY = y;
	}
}

function resizeErrorAreaBig(){
	let tableArea = document.getElementById("tableArea");
	let errorMessages = document.getElementById("errorMessages");
	tableArea.style.width = "70%";
	errorMessages.style.width = "28%";
	let resizeButtonBig = document.getElementById("resizeButtonBig");
	let resizeButtonSmall = document.getElementById("resizeButtonSmall");
	resizeButtonBig.style.display = "none";
	resizeButtonSmall.style.display = "block";
}

function resizeErrorAreaSmall(){
	let tableArea = document.getElementById("tableArea");
	let errorMessages = document.getElementById("errorMessages");
	tableArea.style.width = "85%";
	errorMessages.style.width = "13%";
	let resizeButtonBig = document.getElementById("resizeButtonBig");
	let resizeButtonSmall = document.getElementById("resizeButtonSmall");
	resizeButtonBig.style.display = "block";
	resizeButtonSmall.style.display = "none";
}