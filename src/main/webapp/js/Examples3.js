/*var tutorialTextArray = {
	inputFile: "a",
	newProject: "b",
	generateExampleTable: "c",
	generateTemplateTable: "d",
	addRow: "e",
	addColumn: "f",
	removeRow: "g",
	removeColumn: "h",
	generateTable: "i",
	addTab: "j",
	removeTable: "k",
	removeTab: "l",
	saveSheetJSButton: "m",
	planProject: "n",
	errorMessageArea: "o"
}*/

function generateConfigurationTable(){
	document.getElementById('tableConfiguration-1-1').innerHTML = "Kitsendus";
	document.getElementById('tableConfiguration-1-2').innerHTML = "Kaal";
	document.getElementById('tableConfiguration-1-3').innerHTML = "Kirjeldus";
	document.getElementById('tableConfiguration-1-4').innerHTML = "Tüüp";
	document.getElementById('tableConfiguration-2-1').innerHTML = "Commission has enough members";
	document.getElementById('tableConfiguration-2-2').childNodes[0].value = "5";
	document.getElementById('tableConfiguration-2-3').innerHTML = "Bakalaureuse lõputöö kaitsmisel peab olema kohal piisavalt palju komisjoni liikmeid";
	document.getElementById('tableConfiguration-2-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-3-1').innerHTML = "Author prerequisites done";
	document.getElementById('tableConfiguration-3-2').childNodes[0].value = "12";
	document.getElementById('tableConfiguration-3-3').innerHTML = "Lõputöö kaitsjal peavad olema kõik eeldused täidetud enne lõputöö kaitsmist";
	document.getElementById('tableConfiguration-3-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-4-1').innerHTML = "Defense not on authors unavailable timeslot";
	document.getElementById('tableConfiguration-4-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-4-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja sobimatul kuupäeva kellaajal";
	document.getElementById('tableConfiguration-4-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-5-1').innerHTML = "Defense not on commission members unavailable timeslot";
	document.getElementById('tableConfiguration-5-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-5-3').innerHTML = "Kaitsmine ei toimu komisjoni liikme sobimatul kuupäeva kellaajal";
	document.getElementById('tableConfiguration-5-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-6-1').innerHTML = "Defense has one chairman";
	document.getElementById('tableConfiguration-6-2').childNodes[0].value = "18";
	document.getElementById('tableConfiguration-6-3').innerHTML = "Kaitsmisel peab olema täpselt üks komisjoni esimees";
	document.getElementById('tableConfiguration-6-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-7-1').innerHTML = "Defense grouped by same thesis theme";
	document.getElementById('tableConfiguration-7-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-7-3').innerHTML = "Sarnaste teemadega kaitsmised grupeeritakse kokku";
	document.getElementById('tableConfiguration-7-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-8-1').innerHTML = "Defense authors grouped by common supervisor";
	document.getElementById('tableConfiguration-8-2').childNodes[0].value = "50";
	document.getElementById('tableConfiguration-8-3').innerHTML = "Kui ühel juhendajal on mitu juhendatavat, siis nende kaitsmised grupeeritakse kokku";
	document.getElementById('tableConfiguration-8-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-9-1').innerHTML = "Closed defenses at start or end day or at before or after lunch";
	document.getElementById('tableConfiguration-9-2').childNodes[0].value = "750";
	document.getElementById('tableConfiguration-9-3').innerHTML = "Kinnised kaitsmised toimuvad päeva alguses, lõpus või enne, pärast lõunapausi";
	document.getElementById('tableConfiguration-9-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-10-1').innerHTML = "Defense on authors preferred timeslot";
	document.getElementById('tableConfiguration-10-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-10-3').innerHTML = "Kaitsmine toimub lõputöö kaitsja eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-10-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-11-1').innerHTML = "Defense not on authors not preferred timeslot";
	document.getElementById('tableConfiguration-11-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-11-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja mitte-eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-11-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-12-1').innerHTML = "Defense on commission members preferred timeslot";
	document.getElementById('tableConfiguration-12-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-12-3').innerHTML = "Kaitsmine toimub komisjoni liikme eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-12-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-13-1').innerHTML = "Defense not on commission members not preferred timeslot";
	document.getElementById('tableConfiguration-13-2').childNodes[0].value = "20";
	document.getElementById('tableConfiguration-13-3').innerHTML = "Kaitsmine ei toimu komisjoni liikme mitte-eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-13-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-14-1').innerHTML = "Defense on authors supervisors preferred timeslot";
	document.getElementById('tableConfiguration-14-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-14-3').innerHTML = "Kaitsmine toimub lõputöö kaitsja juhendaja eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-14-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-15-1').innerHTML = "Defense not on authors supervisors not preferred timeslot";
	document.getElementById('tableConfiguration-15-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-15-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja juhendaja mitte-eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-15-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-16-1').innerHTML = "Defense not on authors supervisors unavailable timeslot";
	document.getElementById('tableConfiguration-16-2').childNodes[0].value = "20";
	document.getElementById('tableConfiguration-16-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja juhendaja sobimatul kuupäeva kellaajal";
	document.getElementById('tableConfiguration-16-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-17-1').innerHTML = "Defense on authors preferred timeslot tag";
	document.getElementById('tableConfiguration-17-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-17-3').innerHTML = "Kaitsmine toimub lõputöö kaitsja eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-17-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-18-1').innerHTML = "Defense not on authors not preferred timeslot tag";
	document.getElementById('tableConfiguration-18-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-18-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja mitte-eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-18-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-19-1').innerHTML = "Defense not on authors unavailable timeslot tag";
	document.getElementById('tableConfiguration-19-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-19-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja sobimatul aja märksõnal";
	document.getElementById('tableConfiguration-19-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-20-1').innerHTML = "Defense on commission members preferred timeslot tag";
	document.getElementById('tableConfiguration-20-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-20-3').innerHTML = "Kaitsmine toimub komisjoni liikme eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-20-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-21-1').innerHTML = "Defense not on commission members not preferred timeslot tag";
	document.getElementById('tableConfiguration-21-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-21-3').innerHTML = "Kaitsmine ei toimu komisjoni liikme mitte-eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-21-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-22-1').innerHTML = "Defense not on commission members unavailable timeslot tag";
	document.getElementById('tableConfiguration-22-2').childNodes[0].value = "20";
	document.getElementById('tableConfiguration-22-3').innerHTML = "Kaitsmine ei toimu komisjoni liikme sobimatul aja märksõnal";
	document.getElementById('tableConfiguration-22-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-23-1').innerHTML = "Defense on authors supervisors preferred timeslot tag";
	document.getElementById('tableConfiguration-23-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-23-3').innerHTML = "Kaitsmine toimub lõputöö kaitsja juhendaja eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-23-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-24-1').innerHTML = "Defense not on authors supervisors not preferred timeslot tag";
	document.getElementById('tableConfiguration-24-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-24-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja juhendaja mitte-eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-24-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-25-1').innerHTML = "Defense not on authors supervisors unavailable timeslot tag";
	document.getElementById('tableConfiguration-25-2').childNodes[0].value = "20";
	document.getElementById('tableConfiguration-25-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja juhendaja sobimatul aja märksõnal";
	document.getElementById('tableConfiguration-25-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-26-1').innerHTML = "Commission member does not swap with a new member on the same day";
	document.getElementById('tableConfiguration-26-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-26-3').innerHTML = "Kaitsmisel komisjoni liige ei vaheta oma kohta uue liikmega samal päeval";
	document.getElementById('tableConfiguration-26-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-27-1').innerHTML = "Defense timeslot only for single author";
	document.getElementById('tableConfiguration-27-2').childNodes[0].value = "1000";
	document.getElementById('tableConfiguration-27-3').innerHTML = "Kaitsmisel on autoril ainult üks kaitsmise aeg";
	document.getElementById('tableConfiguration-27-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-28-1').innerHTML = "Commission member does not swap with a new member in the same session";
	document.getElementById('tableConfiguration-28-2').childNodes[0].value = "25";
	document.getElementById('tableConfiguration-28-3').innerHTML = "Kaitsmisel komisjoni liige ei vaheta oma kohta uue liikmega samal sessioonil";
	document.getElementById('tableConfiguration-28-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-29-1').innerHTML = "Defense timeslots grouped by common session and have no holes between them";
	document.getElementById('tableConfiguration-29-2').childNodes[0].value = "40";
	document.getElementById('tableConfiguration-29-3').innerHTML = "Kaitsmise ajad on grupeeritud sarnase sessiooni järgi ja nende vahel pole tühjasid aegasid";
	document.getElementById('tableConfiguration-29-4').innerHTML = "Soft";
}

let generatedKeyWords = ["võtmesõna-1", "võtmesõna-2", "võtmesõna-3", "võtmesõna-4", "võtmesõna-5", "võtmesõna-6", "võtmesõna-7"];
let generatedSupervisorsArray = [];
let generatedAuthorsArray = [];
let generatedCommiteeArray = [];
let generatedDefenseArray = [];
let generatedTimeslotKeys = ["Ei sobi", "Ei eelista", "Eelistab"];


// closedTimeslotType valikud: iga päev algus ja lõpp, iga päev algus, iga päev lõpp, viimasel päeval.
function generateTimeslotTable2(days, timeslotsPerDay, sessions, startTime, startDate, closedTimeslotType, closedTimeslots, timeLength, breakLength, randomize){
	// Add first timeslot row headers
	document.getElementById('tableTimeslot-1-1').innerHTML = "Päev";
	document.getElementById('tableTimeslot-1-2').innerHTML = "Algus";
	document.getElementById('tableTimeslot-1-3').innerHTML = "Lõpp";
	document.getElementById('tableTimeslot-1-4').innerHTML = "Kaitsmise tüüp";
	document.getElementById('tableTimeslot-1-5').innerHTML = "Sessioon";
	document.getElementById('tableTimeslot-1-6').innerHTML = "Võtmesõnad";

	// startDate variables
	let dayInt = parseInt(startDate.substr(0, 2));
	let monthInt = parseInt(startDate.substr(3, 2));
	let yearInt = parseInt(startDate.substr(6, 4));

	// startTime variables
	let hourInt = parseInt(startTime.substr(0, 2));
	let minInt = parseInt(startTime.substr(3, 2));
	let currentHour = hourInt;
	let currentMin = minInt;

	// length variables
	let timeLengthInt = parseInt(timeLength);
	let breakLengthInt = parseInt(breakLength);

	// timeslot variables
	let daysInt = parseInt(days);
	let timeslotsPerDayInt = parseInt(timeslotsPerDay);
	let timeslotsTotal = timeslotsPerDayInt * daysInt;
	let sessionsInt = parseInt(sessions);
	let breakNumPerDay = sessionsInt - 1;
	let breaksTotal = breakNumPerDay * daysInt;
	let totalTimeslots = timeslotsTotal + breaksTotal;
	let daysSet = 1;

	// closed timeslot variables
	let closedTimelotsInt = parseInt(closedTimeslots);
	let closedTimeslotsLeft = closedTimelotsInt;
	let closedTimeslotsPerDay = Math.ceil(closedTimelotsInt / sessionsInt);

	let timeslotsPerSession = Math.ceil(timeslotsPerDayInt / sessionsInt);

	let timeslotNumber = 2;
	let numOfTimeslotForDay = 0;

	let sessionNumber = 1;

	for(let i = 0; i < daysInt; i++){

		for(let j = 0; j < timeslotsPerDay; j++){
			// add closed timeslot, if choice is iga päev
			/*if(closedTimeslotType == "iga päev" && j == 0){

			}*/

			// add break timeslot first if at right time
			if(j % timeslotsPerSession == 0 && j != 0){
				addRow();
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-1').innerHTML = getDoubleDigit(dayInt) + "." + getDoubleDigit(monthInt) + "." + yearInt.toString();
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-2').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
				currentMin += breakLengthInt;
				if(currentMin > 59){
					currentHour++;
					currentMin = currentMin - 60;
				}
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-3').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-4').childNodes[0].value = "Vaheaeg";
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-5').childNodes[0].value = 0;
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-6').childNodes[0].value = "";
				timeslotNumber++;
				sessionNumber++;
			}

			// add new timeslot row
			addRow();
			document.querySelector('#tableTimeslot-' + timeslotNumber + '-1').innerHTML = getDoubleDigit(dayInt) + "." + getDoubleDigit(monthInt) + "." + yearInt.toString();
			document.querySelector('#tableTimeslot-' + timeslotNumber + '-2').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
			currentMin += timeLengthInt;
			if(currentMin > 59){
				currentHour++;
				currentMin = currentMin - 60;
			}
			document.querySelector('#tableTimeslot-' + timeslotNumber + '-3').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
			document.querySelector('#tableTimeslot-' + timeslotNumber + '-4').childNodes[0].value = "Lahtine";
			document.querySelector('#tableTimeslot-' + timeslotNumber + '-5').childNodes[0].value = sessionNumber;
			if(randomize == "yes"){
				let randomChance = Math.floor((Math.random() * 15) + 1);
				if(randomChance == 1){
					let randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-6').childNodes[0].value = generatedKeyWords[randomKeyWord];
				}
			}
			else {
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-6').childNodes[0].value = "";
			}
			timeslotNumber++;

			// add closed timeslot, if choice is viimasel päeval
			if(daysSet == daysInt && closedTimeslotType == "viimasel päeval" && j == timeslotsPerDay-1){
				addRow();
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-1').innerHTML = getDoubleDigit(dayInt) + "." + getDoubleDigit(monthInt) + "." + yearInt.toString();
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-2').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
				currentMin += breakLengthInt;
				if(currentMin > 59){
					currentHour++;
					currentMin = currentMin - 60;
				}
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-3').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-4').childNodes[0].value = "Vaheaeg";
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-5').childNodes[0].value = 0;
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-6').childNodes[0].value = "";
				timeslotNumber++;
				sessionNumber++;
				for(let k = 0; k < closedTimelotsInt; k++){
					addRow();
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-1').innerHTML = getDoubleDigit(dayInt) + "." + getDoubleDigit(monthInt) + "." + yearInt.toString();
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-2').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
					currentMin += timeLengthInt;
					if(currentMin > 59){
						currentHour++;
						currentMin = currentMin - 60;
					}
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-3').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-4').childNodes[0].value = "Kinnine";
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-5').childNodes[0].value = sessionNumber;
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-6').childNodes[0].value = "";
					timeslotNumber++;
				}
			}
		}
		currentHour = hourInt;
		currentMin = minInt;
		dayInt++;
		sessionNumber++;
		daysSet++;
	}
	console.log("generatetimeslottable2");
	console.log("totaltimeslots: " + totalTimeslots);
	console.log("timeslotsPerSession: " + timeslotsPerSession);
	console.log("day, month, year: " + dayInt + "." + monthInt + "." + yearInt);
}

function getDoubleDigit(date){
	if(date < 10){
		return "0" + date;
	}
	return date.toString();
}

function nextDay(day, month, year){

}



function generateTimeslotTable(){
	document.getElementById('tableTimeslot-1-1').innerHTML = "Päev";
	document.getElementById('tableTimeslot-1-2').innerHTML = "Algus";
	document.getElementById('tableTimeslot-1-3').innerHTML = "Lõpp";
	document.getElementById('tableTimeslot-1-4').innerHTML = "Kaitsmise tüüp";
	document.getElementById('tableTimeslot-1-5').innerHTML = "Sessioon";
	document.getElementById('tableTimeslot-1-6').innerHTML = "Võtmesõnad";
	document.getElementById('tableTimeslot-2-1').innerHTML = "03.06.2019";
	document.getElementById('tableTimeslot-2-2').innerHTML = "09:00";
	document.getElementById('tableTimeslot-2-3').innerHTML = "09:20";
	document.getElementById('tableTimeslot-2-4').childNodes[0].value = "Lahtine";
	document.getElementById('tableTimeslot-2-5').childNodes[0].value = "1";
	document.getElementById('tableTimeslot-2-6').childNodes[0].value = "esmaspäev";
	document.getElementById('tableTimeslot-3-1').innerHTML = "03.06.2019";
	document.getElementById('tableTimeslot-3-2').innerHTML = "09:20";
	document.getElementById('tableTimeslot-3-3').innerHTML = "09:40";
	document.getElementById('tableTimeslot-3-4').childNodes[0].value = "Lahtine";
	document.getElementById('tableTimeslot-3-5').childNodes[0].value = "1";
	document.getElementById('tableTimeslot-3-6').childNodes[0].value = "esmaspäev";
	document.getElementById('tableTimeslot-4-1').innerHTML = "03.06.2019";
	document.getElementById('tableTimeslot-4-2').innerHTML = "09:40";
	document.getElementById('tableTimeslot-4-3').innerHTML = "10:00";
	document.getElementById('tableTimeslot-4-4').childNodes[0].value = "Lahtine";
	document.getElementById('tableTimeslot-4-5').childNodes[0].value = "1";
	document.getElementById('tableTimeslot-4-6').childNodes[0].value = "esmaspäev";
	document.getElementById('tableTimeslot-5-1').innerHTML = "03.06.2019";
	document.getElementById('tableTimeslot-5-2').innerHTML = "10:00";
	document.getElementById('tableTimeslot-5-3').innerHTML = "10:20";
	document.getElementById('tableTimeslot-5-4').childNodes[0].value = "Lahtine";
	document.getElementById('tableTimeslot-5-5').childNodes[0].value = "1";
	document.getElementById('tableTimeslot-5-6').childNodes[0].value = "esmaspäev";
	document.getElementById('tableTimeslot-6-1').innerHTML = "03.06.2019";
	document.getElementById('tableTimeslot-6-2').innerHTML = "10:20";
	document.getElementById('tableTimeslot-6-3').innerHTML = "10:40";
	document.getElementById('tableTimeslot-6-4').childNodes[0].value = "Lahtine";
	document.getElementById('tableTimeslot-6-5').childNodes[0].value = "1";
	document.getElementById('tableTimeslot-6-6').childNodes[0].value = "esmaspäev";
	document.getElementById('tableTimeslot-7-1').innerHTML = "03.06.2019";
	document.getElementById('tableTimeslot-7-2').innerHTML = "10:40";
	document.getElementById('tableTimeslot-7-3').innerHTML = "11:00";
	document.getElementById('tableTimeslot-7-4').childNodes[0].value = "";
	document.getElementById('tableTimeslot-7-5').childNodes[0].value = "0";
	document.getElementById('tableTimeslot-7-6').childNodes[0].value = "esmaspäev";
	document.getElementById('tableTimeslot-7-6').childNodes[1].click();
	document.getElementById('tableTimeslot-7-6').childNodes[1].value = "vaheaeg";
	document.getElementById('tableTimeslot-8-1').innerHTML = "03.06.2019";
	document.getElementById('tableTimeslot-8-2').innerHTML = "11:00";
	document.getElementById('tableTimeslot-8-3').innerHTML = "11:20";
	document.getElementById('tableTimeslot-8-4').childNodes[0].value = "Lahtine";
	document.getElementById('tableTimeslot-8-5').childNodes[0].value = "2";
	document.getElementById('tableTimeslot-8-6').childNodes[0].value = "esmaspäev";
	document.getElementById('tableTimeslot-9-1').innerHTML = "04.06.2019";
	document.getElementById('tableTimeslot-9-2').innerHTML = "09:00";
	document.getElementById('tableTimeslot-9-3').innerHTML = "09:20";
	document.getElementById('tableTimeslot-9-4').childNodes[0].value = "Lahtine";
	document.getElementById('tableTimeslot-9-5').childNodes[0].value = "3";
	document.getElementById('tableTimeslot-9-6').childNodes[0].value = "teisipäev";
	document.getElementById('tableTimeslot-10-1').innerHTML = "04.06.2019";
	document.getElementById('tableTimeslot-10-2').innerHTML = "09:20";
	document.getElementById('tableTimeslot-10-3').innerHTML = "09:40";
	document.getElementById('tableTimeslot-10-4').childNodes[0].value = "Lahtine";
	document.getElementById('tableTimeslot-10-5').childNodes[0].value = "3";
	document.getElementById('tableTimeslot-10-6').childNodes[0].value = "teisipäev";
	document.getElementById('tableTimeslot-11-1').innerHTML = "04.06.2019";
	document.getElementById('tableTimeslot-11-2').innerHTML = "09:40";
	document.getElementById('tableTimeslot-11-3').innerHTML = "10:00";
	document.getElementById('tableTimeslot-11-4').childNodes[0].value = "Lahtine";
	document.getElementById('tableTimeslot-11-5').childNodes[0].value = "3";
	document.getElementById('tableTimeslot-11-6').childNodes[0].value = "teisipäev";
	document.getElementById('tableTimeslot-12-1').innerHTML = "04.06.2019";
	document.getElementById('tableTimeslot-12-2').innerHTML = "10:00";
	document.getElementById('tableTimeslot-12-3').innerHTML = "10:20";
	document.getElementById('tableTimeslot-12-4').childNodes[0].value = "";
	document.getElementById('tableTimeslot-12-5').childNodes[0].value = "0";
	document.getElementById('tableTimeslot-12-6').childNodes[0].value = "teisipäev";
	document.getElementById('tableTimeslot-12-6').childNodes[1].click();
	document.getElementById('tableTimeslot-12-6').childNodes[1].value = "vaheaeg";
	document.getElementById('tableTimeslot-13-1').innerHTML = "04.06.2019";
	document.getElementById('tableTimeslot-13-2').innerHTML = "10:20";
	document.getElementById('tableTimeslot-13-3').innerHTML = "10:40";
	document.getElementById('tableTimeslot-13-4').childNodes[0].value = "Kinnine";
	document.getElementById('tableTimeslot-13-5').childNodes[0].value = "4";
	document.getElementById('tableTimeslot-13-6').childNodes[0].value = "teisipäev";
	document.getElementById('tableTimeslot-14-1').innerHTML = "04.06.2019";
	document.getElementById('tableTimeslot-14-2').innerHTML = "10:40";
	document.getElementById('tableTimeslot-14-3').innerHTML = "11:00";
	document.getElementById('tableTimeslot-14-4').childNodes[0].value = "Kinnine";
	document.getElementById('tableTimeslot-14-5').childNodes[0].value = "4";
	document.getElementById('tableTimeslot-14-6').childNodes[0].value = "teisipäev";
	document.getElementById('tableTimeslot-15-1').innerHTML = "04.06.2019";
	document.getElementById('tableTimeslot-15-2').innerHTML = "11:00";
	document.getElementById('tableTimeslot-15-3').innerHTML = "11:20";
	document.getElementById('tableTimeslot-15-4').childNodes[0].value = "Kinnine";
	document.getElementById('tableTimeslot-15-5').childNodes[0].value = "4";
	document.getElementById('tableTimeslot-15-6').childNodes[0].value = "teisipäev";
}

function generateAuthorTable(){
	document.getElementById('tableAuthor-1-1').innerHTML = "";
	document.getElementById('tableAuthor-1-2').innerHTML = "";
	document.getElementById('tableAuthor-1-3').innerHTML = "";
	document.getElementById('tableAuthor-1-4').innerHTML = "";
	document.getElementById('tableAuthor-1-5').innerHTML = "";
	document.getElementById('tableAuthor-1-6').innerHTML = "";
	document.getElementById('tableAuthor-1-7').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-8').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-9').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-10').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-11').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-12').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-13').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-1-14').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-1-15').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-1-16').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-1-17').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-1-18').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-2-1').innerHTML = "Nimi";
	document.getElementById('tableAuthor-2-2').innerHTML = "Eeldused on täidetud";
	document.getElementById('tableAuthor-2-3').innerHTML = "Juhendajad";
	document.getElementById('tableAuthor-2-4').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableAuthor-2-5').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableAuthor-2-6').innerHTML = "Sobimatud märksõnad";
	document.getElementById('tableAuthor-2-7').innerHTML = "09:00-09:20";
	document.getElementById('tableAuthor-2-8').innerHTML = "09:20-09:40";
	document.getElementById('tableAuthor-2-9').innerHTML = "09:40-10:00";
	document.getElementById('tableAuthor-2-10').innerHTML = "10:20-10:40";
	document.getElementById('tableAuthor-2-11').innerHTML = "10:40-11:00";
	document.getElementById('tableAuthor-2-12').innerHTML = "11:00-11:20";
	document.getElementById('tableAuthor-2-13').innerHTML = "09:00-09:20";
	document.getElementById('tableAuthor-2-14').innerHTML = "09:20-09:40";
	document.getElementById('tableAuthor-2-15').innerHTML = "09:40-10:00";
	document.getElementById('tableAuthor-2-16').innerHTML = "10:20-10:40";
	document.getElementById('tableAuthor-2-17').innerHTML = "10:40-11:00";
	document.getElementById('tableAuthor-2-18').innerHTML = "11:00-11:20";
	document.getElementById('tableAuthor-3-1').innerHTML = "Roald Välja";
	document.getElementById('tableAuthor-3-2').childNodes[0].value = "Jah";
	document.getElementById('tableAuthor-3-3').childNodes[0].value = "Riina Maigre";
	document.getElementById('tableAuthor-3-4').childNodes[0].value = "";
	document.getElementById('tableAuthor-3-5').childNodes[0].value = "teisipäev";
	document.getElementById('tableAuthor-3-6').childNodes[0].value = "";
	document.getElementById('tableAuthor-3-7').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-3-8').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-3-9').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-3-10').childNodes[0].value = "";
	document.getElementById('tableAuthor-3-11').childNodes[0].value = "";
	document.getElementById('tableAuthor-3-12').childNodes[0].value = "";
	document.getElementById('tableAuthor-3-13').childNodes[0].value = "";
	document.getElementById('tableAuthor-3-14').childNodes[0].value = "";
	document.getElementById('tableAuthor-3-15').childNodes[0].value = "";
	document.getElementById('tableAuthor-3-16').childNodes[0].value = "Eelistab";
	document.getElementById('tableAuthor-3-17').childNodes[0].value = "Eelistab";
	document.getElementById('tableAuthor-3-18').childNodes[0].value = "Eelistab";
	document.getElementById('tableAuthor-4-1').innerHTML = "Tom Smith";
	document.getElementById('tableAuthor-4-2').childNodes[0].value = "Jah";
	document.getElementById('tableAuthor-4-3').childNodes[0].value = "Henrik Kuusik";
	document.getElementById('tableAuthor-4-3').childNodes[1].click();
	document.getElementById('tableAuthor-4-3').childNodes[1].value = "Ilgar Männilaa";
	document.getElementById('tableAuthor-4-4').childNodes[0].value = "";
	document.getElementById('tableAuthor-4-5').childNodes[0].value = "";
	document.getElementById('tableAuthor-4-6').childNodes[0].value = "";
	document.getElementById('tableAuthor-4-7').childNodes[0].value = "";
	document.getElementById('tableAuthor-4-8').childNodes[0].value = "";
	document.getElementById('tableAuthor-4-9').childNodes[0].value = "";
	document.getElementById('tableAuthor-4-10').childNodes[0].value = "";
	document.getElementById('tableAuthor-4-11').childNodes[0].value = "";
	document.getElementById('tableAuthor-4-12').childNodes[0].value = "";
	document.getElementById('tableAuthor-4-13').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-4-14').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-4-15').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-4-16').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-4-17').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-4-18').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-5-1').innerHTML = "Ami Hennig";
	document.getElementById('tableAuthor-5-2').childNodes[0].value = "Jah";
	document.getElementById('tableAuthor-5-3').childNodes[0].value = "Peeter Oja";
	document.getElementById('tableAuthor-5-4').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-5').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-6').childNodes[0].value = "esmaspäev";
	document.getElementById('tableAuthor-5-7').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-8').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-9').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-10').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-11').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-12').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-13').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-14').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-15').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-16').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-17').childNodes[0].value = "";
	document.getElementById('tableAuthor-5-18').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-1').innerHTML = "Kairi Luts";
	document.getElementById('tableAuthor-6-2').childNodes[0].value = "Jah";
	document.getElementById('tableAuthor-6-3').childNodes[0].value = "Mart Märdikas";
	document.getElementById('tableAuthor-6-4').childNodes[0].value = "esmaspäev";
	document.getElementById('tableAuthor-6-4').childNodes[1].click();
	document.getElementById('tableAuthor-6-4').childNodes[1].value = "teisipäev";
	document.getElementById('tableAuthor-6-5').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-6').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-7').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-8').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-9').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-10').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-11').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-12').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-13').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-14').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-15').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-16').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-17').childNodes[0].value = "";
	document.getElementById('tableAuthor-6-18').childNodes[0].value = "";
	document.getElementById('tableAuthor-7-1').innerHTML = "Mihkel Roomets";
	document.getElementById('tableAuthor-7-2').childNodes[0].value = "Ei";
	document.getElementById('tableAuthor-7-3').childNodes[0].value = "Oskar Hobune";
	document.getElementById('tableAuthor-7-4').childNodes[0].value = "";
	document.getElementById('tableAuthor-7-5').childNodes[0].value = "";
	document.getElementById('tableAuthor-7-6').childNodes[0].value = "";
	document.getElementById('tableAuthor-7-7').childNodes[0].value = "Eelistab";
	document.getElementById('tableAuthor-7-8').childNodes[0].value = "Eelistab";
	document.getElementById('tableAuthor-7-9').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-7-10').childNodes[0].value = "";
	document.getElementById('tableAuthor-7-11').childNodes[0].value = "";
	document.getElementById('tableAuthor-7-12').childNodes[0].value = "";
	document.getElementById('tableAuthor-7-13').childNodes[0].value = "Eelistab";
	document.getElementById('tableAuthor-7-14').childNodes[0].value = "Eelistab";
	document.getElementById('tableAuthor-7-15').childNodes[0].value = "Ei sobi";
	document.getElementById('tableAuthor-7-16').childNodes[0].value = "";
	document.getElementById('tableAuthor-7-17').childNodes[0].value = "";
	document.getElementById('tableAuthor-7-18').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-1').innerHTML = "Karl Loopuu";
	document.getElementById('tableAuthor-8-2').childNodes[0].value = "Jah";
	document.getElementById('tableAuthor-8-3').childNodes[0].value = "Oliver Väärmees";
	document.getElementById('tableAuthor-8-4').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-5').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-6').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-7').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-8').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-9').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-10').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-11').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-12').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-13').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-14').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-15').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-16').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-17').childNodes[0].value = "";
	document.getElementById('tableAuthor-8-18').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-1').innerHTML = "Kelli Tulp";
	document.getElementById('tableAuthor-9-2').childNodes[0].value = "Jah";
	document.getElementById('tableAuthor-9-3').childNodes[0].value = "Milly Baker";
	document.getElementById('tableAuthor-9-4').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-5').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-6').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-7').childNodes[0].value = "Eelistab";
	document.getElementById('tableAuthor-9-8').childNodes[0].value = "Eelistab";
	document.getElementById('tableAuthor-9-9').childNodes[0].value = "Eelistab";
	document.getElementById('tableAuthor-9-10').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-11').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-12').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-13').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-14').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-15').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-16').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-17').childNodes[0].value = "";
	document.getElementById('tableAuthor-9-18').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-1').innerHTML = "Andres Suursoo";
	document.getElementById('tableAuthor-10-2').childNodes[0].value = "Ei";
	document.getElementById('tableAuthor-10-3').childNodes[0].value = "Pille Männik";
	document.getElementById('tableAuthor-10-4').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-5').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-6').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-7').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-8').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-9').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-10').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-11').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-12').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-13').childNodes[0].value = "Ei eelista";
	document.getElementById('tableAuthor-10-14').childNodes[0].value = "Ei eelista";
	document.getElementById('tableAuthor-10-15').childNodes[0].value = "Ei eelista";
	document.getElementById('tableAuthor-10-16').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-17').childNodes[0].value = "";
	document.getElementById('tableAuthor-10-18').childNodes[0].value = "";
}

function generateSupervisorTable2(amount){
	// add first and second row first
	document.getElementById('tableSupervisor-1-1').innerHTML = "";
	document.getElementById('tableSupervisor-1-2').innerHTML = "";
	document.getElementById('tableSupervisor-1-3').innerHTML = "";
	document.getElementById('tableSupervisor-1-4').innerHTML = "";
	document.getElementById('tableSupervisor-1-5').innerHTML = "";
	document.getElementById('tableSupervisor-2-1').innerHTML = "Nimi";
	document.getElementById('tableSupervisor-2-2').innerHTML = "Roll";
	document.getElementById('tableSupervisor-2-3').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableSupervisor-2-4').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableSupervisor-2-5').innerHTML = "Sobimatud märksõnad";
	let columns = document.querySelector('#tableSupervisor').childNodes[0].childNodes[0].childElementCount;
	console.log("Column count: " + columns);

	let oldTimeslotDate = "";
	let oldKey = "";

	for(let i = 0; i < amount; i++){
		addRow();
		document.querySelector('#tableSupervisor-' + (i+3) + '-1').innerHTML = "Juhendaja-" + (i+1);
		let randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		let randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableSupervisor-' + (i+3) + '-3').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableSupervisor-' + (i+3) + '-4').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableSupervisor-' + (i+3) + '-5').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		for(let j = 5; j < columns; j++){
			let timeslotDate = document.querySelector('#tableSupervisor').childNodes[0].childNodes[0].childNodes[j].innerHTML;
			//console.log("abc kontroll: " + "#tableSupervisor-1-" + j);
			if(oldTimeslotDate != timeslotDate){
				//console.log("uus date");
				oldKey = "";
				randomKey = Math.floor((Math.random() * generatedTimeslotKeys.length));
				randomChance = Math.floor((Math.random() * 10) + 1);
				if(randomChance == 1){
					oldKey = generatedTimeslotKeys[randomKey];
					document.querySelector('#tableSupervisor').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
				}	
				
			}
			else if(oldTimeslotDate == timeslotDate) {
				console.log("vana date");
				document.querySelector('#tableSupervisor').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
			}
			oldTimeslotDate = timeslotDate;
		}
		generatedSupervisorsArray[i] = "Juhendaja-" + (i+1);
	}
}

function generateAuthorTable2(amount){
	// add first and second row first
	document.getElementById('tableAuthor-1-1').innerHTML = "";
	document.getElementById('tableAuthor-1-2').innerHTML = "";
	document.getElementById('tableAuthor-1-3').innerHTML = "";
	document.getElementById('tableAuthor-1-4').innerHTML = "";
	document.getElementById('tableAuthor-1-5').innerHTML = "";
	document.getElementById('tableAuthor-1-6').innerHTML = "";
	document.getElementById('tableAuthor-2-1').innerHTML = "Nimi";
	document.getElementById('tableAuthor-2-2').innerHTML = "Eeldused on täidetud";
	document.getElementById('tableAuthor-2-3').innerHTML = "Juhendajad";
	document.getElementById('tableAuthor-2-4').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableAuthor-2-5').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableAuthor-2-6').innerHTML = "Sobimatud märksõnad";
	let columns = document.querySelector('#tableAuthor').childNodes[0].childNodes[0].childElementCount;
	console.log("Column count: " + columns);

	let oldTimeslotDate = "";
	let oldKey = "";

	for(let i = 0; i < amount; i++){
		addRow();
		document.querySelector('#tableAuthor-' + (i+3) + '-1').innerHTML = "Autor-" + (i+1);

		let randomSupervisor = Math.floor((Math.random() * generatedSupervisorsArray.length));
		let randomSupervisor2;
		console.log("lisatakse supervisor autorile");
		document.querySelector('#tableAuthor').childNodes[0].childNodes[i+2].childNodes[2].childNodes[0].value = generatedSupervisorsArray[randomSupervisor];
		let randomChanceSupervisor = Math.floor((Math.random() * 10) + 1);
		if(randomChanceSupervisor == 1) {
			document.querySelector('#tableAuthor').childNodes[0].childNodes[i+2].childNodes[2].childNodes[1].click();
			while(true){
				randomSupervisor2 = Math.floor((Math.random() * generatedSupervisorsArray.length));
				console.log("siin on numbrid: " + randomSupervisor + "-" + randomSupervisor2);
				if(randomSupervisor != randomSupervisor2){
					console.log("Leiti erinevad supervisorid: " + randomSupervisor + " _ " + randomSupervisor2);
					document.querySelector('#tableAuthor').childNodes[0].childNodes[i+2].childNodes[2].childNodes[1].value = generatedSupervisorsArray[randomSupervisor2];
					break;
				}
			}
		}

		let randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		let randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableAuthor-' + (i+3) + '-4').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableAuthor-' + (i+3) + '-5').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableAuthor-' + (i+3) + '-6').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		for(let j = 6; j < columns; j++){
			let timeslotDate = document.querySelector('#tableAuthor').childNodes[0].childNodes[0].childNodes[j].innerHTML;
			//console.log("abc kontroll: " + "#tableAuthor-1-" + j);
			if(oldTimeslotDate != timeslotDate){
				//console.log("uus date");
				oldKey = "";
				randomKey = Math.floor((Math.random() * generatedTimeslotKeys.length));
				randomChance = Math.floor((Math.random() * 5) + 1);
				if(randomChance == 1){
					oldKey = generatedTimeslotKeys[randomKey];
					document.querySelector('#tableAuthor').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
				}	
				
			}
			else if(oldTimeslotDate == timeslotDate) {
				console.log("vana date");
				document.querySelector('#tableAuthor').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
			}
			oldTimeslotDate = timeslotDate;
		}
		generatedAuthorsArray[i] = "Autor-" + (i+1);
	}
}

function generateCommiteeTable2(amount){
	// add first and second row first
	document.getElementById('tableCommitee-1-1').innerHTML = "";
	document.getElementById('tableCommitee-1-2').innerHTML = "";
	document.getElementById('tableCommitee-1-3').innerHTML = "";
	document.getElementById('tableCommitee-1-4').innerHTML = "";
	document.getElementById('tableCommitee-1-5').innerHTML = "";
	document.getElementById('tableCommitee-1-6').innerHTML = "";
	document.getElementById('tableCommitee-2-1').innerHTML = "Nimi";
	document.getElementById('tableCommitee-2-2').innerHTML = "Kraad";
	document.getElementById('tableCommitee-2-3').innerHTML = "Esimees";
	document.getElementById('tableCommitee-2-4').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableCommitee-2-5').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableCommitee-2-6').innerHTML = "Sobimatud märksõnad";
	let columns = document.querySelector('#tableCommitee').childNodes[0].childNodes[0].childElementCount;
	console.log("Column count: " + columns);

	let oldTimeslotDate = "";
	let oldKey = "";

	for(let i = 0; i < amount; i++){
		addRow();
		document.querySelector('#tableCommitee-' + (i+3) + '-1').innerHTML = "Komisjon-" + (i+1);

		if(i == 0){
			document.querySelector('#tableCommitee-' + (i+3) + '-3').childNodes[0].value = "Esimees";
		}
		else if(i == 1){
			document.querySelector('#tableCommitee-' + (i+3) + '-3').childNodes[0].value = "Aseesimees";
		}

		let randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		let randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableCommitee-' + (i+3) + '-4').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableCommitee-' + (i+3) + '-5').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableCommitee-' + (i+3) + '-6').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		for(let j = 6; j < columns; j++){
			let timeslotDate = document.querySelector('#tableCommitee').childNodes[0].childNodes[0].childNodes[j].innerHTML;
			//console.log("abc kontroll: " + "#tableCommitee-1-" + j);
			if(oldTimeslotDate != timeslotDate){
				//console.log("uus date");
				oldKey = "";
				randomKey = Math.floor((Math.random() * generatedTimeslotKeys.length));
				randomChance = Math.floor((Math.random() * 10) + 1);
				if(randomChance == 1){
					oldKey = generatedTimeslotKeys[randomKey];
					document.querySelector('#tableCommitee').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
				}	
				
			}
			else if(oldTimeslotDate == timeslotDate) {
				console.log("vana date");
				document.querySelector('#tableCommitee').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
			}
			oldTimeslotDate = timeslotDate;
		}
		generatedCommiteeArray[i] = "Komisjon-" + (i+1);
	}
}

function generateDefenseTable2(amount){
	// add first and second row first
	document.getElementById('tableDefense-1-1').innerHTML = "Kood";
	document.getElementById('tableDefense-1-2').innerHTML = "Lõputöö pealkiri";
	document.getElementById('tableDefense-1-3').innerHTML = "Kaitsmise tüüp";
	document.getElementById('tableDefense-1-4').innerHTML = "Lõputöö kraad";
	document.getElementById('tableDefense-1-5').innerHTML = "Lõputöö autor";
	document.getElementById('tableDefense-1-6').innerHTML = "Sarnane lõputöö teema";
	document.getElementById('tableDefense-1-7').innerHTML = "Ruumi nr";
	document.getElementById('tableDefense-1-8').innerHTML = "Ruumi maht";
	document.getElementById('tableDefense-1-9').innerHTML = "Komisjoni suurus";

	for(let i = 0; i < amount; i++){
		addRow();
		if(i < 9) {
			document.querySelector('#tableDefense-' + (i+2) + '-1').innerHTML = "D00" + (i+1);
		} else if(i < 99){
			document.querySelector('#tableDefense-' + (i+2) + '-1').innerHTML = "D0" + (i+1);
		} else{
			document.querySelector('#tableDefense-' + (i+2) + '-1').innerHTML = "D" + (i+1);
		}
		document.querySelector('#tableDefense-' + (i+2) + '-2').innerHTML = "Kaitsmine-" + (i+1);

		let randomChance = Math.floor((Math.random() * 100) + 1);
		if(randomChance == 1){
			document.querySelector('#tableDefense-' + (i+2) + '-3').childNodes[0].value = "Kinnine";
		} else {
			document.querySelector('#tableDefense-' + (i+2) + '-3').childNodes[0].value = "Lahtine";
		}
		while(true){
			randomKeyWord = Math.floor((Math.random() * generatedAuthorsArray.length));
			if(generatedAuthorsArray[randomKeyWord] != ""){
				document.querySelector('#tableDefense-' + (i+2) + '-5').childNodes[0].value = generatedAuthorsArray[randomKeyWord];
				generatedAuthorsArray[randomKeyWord] = "";
				break;
			}
		}
		document.querySelector('#tableDefense-' + (i+2) + '-7').innerHTML = "ICT-410";
		document.querySelector('#tableDefense-' + (i+2) + '-9').childNodes[0].value = "3";
	}
}

function generateSupervisorTable(){
	document.getElementById('tableSupervisor-1-1').innerHTML = "";
	document.getElementById('tableSupervisor-1-2').innerHTML = "";
	document.getElementById('tableSupervisor-1-3').innerHTML = "";
	document.getElementById('tableSupervisor-1-4').innerHTML = "";
	document.getElementById('tableSupervisor-1-5').innerHTML = "";
	document.getElementById('tableSupervisor-1-6').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-7').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-8').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-9').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-10').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-11').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-12').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-1-13').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-1-14').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-1-15').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-1-16').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-1-17').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-2-1').innerHTML = "Nimi";
	document.getElementById('tableSupervisor-2-2').innerHTML = "Roll";
	document.getElementById('tableSupervisor-2-3').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableSupervisor-2-4').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableSupervisor-2-5').innerHTML = "Sobimatud märksõnad";
	document.getElementById('tableSupervisor-2-6').innerHTML = "09:00-09:20";
	document.getElementById('tableSupervisor-2-7').innerHTML = "09:20-09:40";
	document.getElementById('tableSupervisor-2-8').innerHTML = "09:40-10:00";
	document.getElementById('tableSupervisor-2-9').innerHTML = "10:20-10:40";
	document.getElementById('tableSupervisor-2-10').innerHTML = "10:40-11:00";
	document.getElementById('tableSupervisor-2-11').innerHTML = "11:00-11:20";
	document.getElementById('tableSupervisor-2-12').innerHTML = "09:00-09:20";
	document.getElementById('tableSupervisor-2-13').innerHTML = "09:20-09:40";
	document.getElementById('tableSupervisor-2-14').innerHTML = "09:40-10:00";
	document.getElementById('tableSupervisor-2-15').innerHTML = "10:20-10:40";
	document.getElementById('tableSupervisor-2-16').innerHTML = "10:40-11:00";
	document.getElementById('tableSupervisor-2-17').innerHTML = "11:00-11:20";
	document.getElementById('tableSupervisor-3-1').innerHTML = "Riina Maigre";
	document.getElementById('tableSupervisor-3-2').childNodes[0].value = "Peajuhendaja";
	document.getElementById('tableSupervisor-3-3').childNodes[0].value = "";
	document.getElementById('tableSupervisor-3-4').childNodes[0].value = "";
	document.getElementById('tableSupervisor-3-5').childNodes[0].value = "";
	document.getElementById('tableSupervisor-3-6').childNodes[0].value = "";
	document.getElementById('tableSupervisor-3-7').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-3-8').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-3-9').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-3-10').childNodes[0].value = "";
	document.getElementById('tableSupervisor-3-11').childNodes[0].value = "";
	document.getElementById('tableSupervisor-3-12').childNodes[0].value = "";
	document.getElementById('tableSupervisor-3-13').childNodes[0].value = "";
	document.getElementById('tableSupervisor-3-14').childNodes[0].value = "";
	document.getElementById('tableSupervisor-3-15').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-3-16').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-3-17').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-4-1').innerHTML = "Henrik Kuusik";
	document.getElementById('tableSupervisor-4-2').childNodes[0].value = "Peajuhendaja";
	document.getElementById('tableSupervisor-4-3').childNodes[0].value = "";
	document.getElementById('tableSupervisor-4-4').childNodes[0].value = "";
	document.getElementById('tableSupervisor-4-5').childNodes[0].value = "";
	document.getElementById('tableSupervisor-4-6').childNodes[0].value = "";
	document.getElementById('tableSupervisor-4-7').childNodes[0].value = "";
	document.getElementById('tableSupervisor-4-8').childNodes[0].value = "";
	document.getElementById('tableSupervisor-4-9').childNodes[0].value = "";
	document.getElementById('tableSupervisor-4-10').childNodes[0].value = "";
	document.getElementById('tableSupervisor-4-11').childNodes[0].value = "";
	document.getElementById('tableSupervisor-4-12').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-4-13').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-4-14').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-4-15').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-4-16').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-4-17').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-5-1').innerHTML = "Ilgar Männilaa";
	document.getElementById('tableSupervisor-5-2').childNodes[0].value = "Kaasjuhendaja";
	document.getElementById('tableSupervisor-5-3').childNodes[0].value = "esmaspäev";
	document.getElementById('tableSupervisor-5-4').childNodes[0].value = "";
	document.getElementById('tableSupervisor-5-5').childNodes[0].value = "";
	document.getElementById('tableSupervisor-5-6').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-5-7').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-5-8').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-5-9').childNodes[0].value = "";
	document.getElementById('tableSupervisor-5-10').childNodes[0].value = "";
	document.getElementById('tableSupervisor-5-11').childNodes[0].value = "";
	document.getElementById('tableSupervisor-5-12').childNodes[0].value = "";
	document.getElementById('tableSupervisor-5-13').childNodes[0].value = "";
	document.getElementById('tableSupervisor-5-14').childNodes[0].value = "";
	document.getElementById('tableSupervisor-5-15').childNodes[0].value = "";
	document.getElementById('tableSupervisor-5-16').childNodes[0].value = "";
	document.getElementById('tableSupervisor-5-17').childNodes[0].value = "";
	document.getElementById('tableSupervisor-6-1').innerHTML = "Peeter Oja";
	document.getElementById('tableSupervisor-6-2').childNodes[0].value = "Peajuhendaja";
	document.getElementById('tableSupervisor-6-3').childNodes[0].value = "";
	document.getElementById('tableSupervisor-6-4').childNodes[0].value = "teisipäev";
	document.getElementById('tableSupervisor-6-5').childNodes[0].value = "";
	document.getElementById('tableSupervisor-6-6').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-6-7').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-6-8').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-6-9').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-6-10').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-6-11').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-6-12').childNodes[0].value = "";
	document.getElementById('tableSupervisor-6-13').childNodes[0].value = "";
	document.getElementById('tableSupervisor-6-14').childNodes[0].value = "";
	document.getElementById('tableSupervisor-6-15').childNodes[0].value = "";
	document.getElementById('tableSupervisor-6-16').childNodes[0].value = "";
	document.getElementById('tableSupervisor-6-17').childNodes[0].value = "";
	document.getElementById('tableSupervisor-7-1').innerHTML = "Mart Märdikas";
	document.getElementById('tableSupervisor-7-2').childNodes[0].value = "Peajuhendaja";
	document.getElementById('tableSupervisor-7-3').childNodes[0].value = "";
	document.getElementById('tableSupervisor-7-4').childNodes[0].value = "";
	document.getElementById('tableSupervisor-7-5').childNodes[0].value = "esmaspäev";
	document.getElementById('tableSupervisor-7-6').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-7-7').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-7-8').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-7-9').childNodes[0].value = "";
	document.getElementById('tableSupervisor-7-10').childNodes[0].value = "";
	document.getElementById('tableSupervisor-7-11').childNodes[0].value = "";
	document.getElementById('tableSupervisor-7-12').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-7-13').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-7-14').childNodes[0].value = "Ei sobi";
	document.getElementById('tableSupervisor-7-15').childNodes[0].value = "";
	document.getElementById('tableSupervisor-7-16').childNodes[0].value = "";
	document.getElementById('tableSupervisor-7-17').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-1').innerHTML = "Oskar Hobune";
	document.getElementById('tableSupervisor-8-2').childNodes[0].value = "Peajuhendaja";
	document.getElementById('tableSupervisor-8-3').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-4').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-5').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-6').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-7').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-8').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-9').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-10').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-11').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-12').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-13').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-14').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-15').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-16').childNodes[0].value = "";
	document.getElementById('tableSupervisor-8-17').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-1').innerHTML = "Oliver Väärmees";
	document.getElementById('tableSupervisor-9-2').childNodes[0].value = "Peajuhendaja";
	document.getElementById('tableSupervisor-9-3').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-4').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-5').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-6').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-7').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-8').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-9').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-9-10').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-9-11').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-9-12').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-13').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-14').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-15').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-16').childNodes[0].value = "";
	document.getElementById('tableSupervisor-9-17').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-1').innerHTML = "Milly Baker";
	document.getElementById('tableSupervisor-10-2').childNodes[0].value = "Peajuhendaja";
	document.getElementById('tableSupervisor-10-3').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-4').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-5').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-6').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-7').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-8').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-9').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-10').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-11').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-12').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-13').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-14').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-15').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-16').childNodes[0].value = "";
	document.getElementById('tableSupervisor-10-17').childNodes[0].value = "";
	document.getElementById('tableSupervisor-11-1').innerHTML = "Pille Männik";
	document.getElementById('tableSupervisor-11-2').childNodes[0].value = "Peajuhendaja";
	document.getElementById('tableSupervisor-11-3').childNodes[0].value = "";
	document.getElementById('tableSupervisor-11-4').childNodes[0].value = "";
	document.getElementById('tableSupervisor-11-5').childNodes[0].value = "";
	document.getElementById('tableSupervisor-11-6').childNodes[0].value = "";
	document.getElementById('tableSupervisor-11-7').childNodes[0].value = "";
	document.getElementById('tableSupervisor-11-8').childNodes[0].value = "";
	document.getElementById('tableSupervisor-11-9').childNodes[0].value = "Ei eelista";
	document.getElementById('tableSupervisor-11-10').childNodes[0].value = "Ei eelista";
	document.getElementById('tableSupervisor-11-11').childNodes[0].value = "Ei eelista";
	document.getElementById('tableSupervisor-11-12').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-11-13').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-11-14').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-11-15').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-11-16').childNodes[0].value = "Eelistab";
	document.getElementById('tableSupervisor-11-17').childNodes[0].value = "Eelistab";
}

function generateCommiteeTable(){
	document.getElementById('tableCommitee-1-1').innerHTML = "";
	document.getElementById('tableCommitee-1-2').innerHTML = "";
	document.getElementById('tableCommitee-1-3').innerHTML = "";
	document.getElementById('tableCommitee-1-4').innerHTML = "";
	document.getElementById('tableCommitee-1-5').innerHTML = "";
	document.getElementById('tableCommitee-1-6').innerHTML = "";
	document.getElementById('tableCommitee-1-7').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-8').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-9').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-10').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-11').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-12').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-13').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-1-14').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-1-15').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-1-16').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-1-17').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-1-18').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-2-1').innerHTML = "Nimi";
	document.getElementById('tableCommitee-2-2').innerHTML = "Kraad";
	document.getElementById('tableCommitee-2-3').innerHTML = "Esimees";
	document.getElementById('tableCommitee-2-4').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableCommitee-2-5').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableCommitee-2-6').innerHTML = "Sobimatud märksõnad";
	document.getElementById('tableCommitee-2-7').innerHTML = "09:00-09:20";
	document.getElementById('tableCommitee-2-8').innerHTML = "09:20-09:40";
	document.getElementById('tableCommitee-2-9').innerHTML = "09:40-10:00";
	document.getElementById('tableCommitee-2-10').innerHTML = "10:20-10:40";
	document.getElementById('tableCommitee-2-11').innerHTML = "10:40-11:00";
	document.getElementById('tableCommitee-2-12').innerHTML = "11:00-11:20";
	document.getElementById('tableCommitee-2-13').innerHTML = "09:00-09:20";
	document.getElementById('tableCommitee-2-14').innerHTML = "09:20-09:40";
	document.getElementById('tableCommitee-2-15').innerHTML = "09:40-10:00";
	document.getElementById('tableCommitee-2-16').innerHTML = "10:20-10:40";
	document.getElementById('tableCommitee-2-17').innerHTML = "10:40-11:00";
	document.getElementById('tableCommitee-2-18').innerHTML = "11:00-11:20";
	document.getElementById('tableCommitee-3-1').innerHTML = "Gert Kanter";
	document.getElementById('tableCommitee-3-2').childNodes[0].value = "Doktor";
	document.getElementById('tableCommitee-3-3').childNodes[0].value = "Esimees";
	document.getElementById('tableCommitee-3-4').childNodes[0].value = "esmaspäev";
	document.getElementById('tableCommitee-3-5').childNodes[0].value = "teisipäev";
	document.getElementById('tableCommitee-3-6').childNodes[0].value = "";
	document.getElementById('tableCommitee-3-7').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-3-8').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-3-9').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-3-10').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-3-11').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-3-12').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-3-13').childNodes[0].value = "";
	document.getElementById('tableCommitee-3-14').childNodes[0].value = "";
	document.getElementById('tableCommitee-3-15').childNodes[0].value = "";
	document.getElementById('tableCommitee-3-16').childNodes[0].value = "";
	document.getElementById('tableCommitee-3-17').childNodes[0].value = "";
	document.getElementById('tableCommitee-3-18').childNodes[0].value = "";
	document.getElementById('tableCommitee-4-1').innerHTML = "Priit Järv";
	document.getElementById('tableCommitee-4-2').childNodes[0].value = "Magister";
	document.getElementById('tableCommitee-4-3').childNodes[0].value = "Ei";
	document.getElementById('tableCommitee-4-4').childNodes[0].value = "";
	document.getElementById('tableCommitee-4-5').childNodes[0].value = "";
	document.getElementById('tableCommitee-4-6').childNodes[0].value = "";
	document.getElementById('tableCommitee-4-7').childNodes[0].value = "Ei eelista";
	document.getElementById('tableCommitee-4-8').childNodes[0].value = "Ei eelista";
	document.getElementById('tableCommitee-4-9').childNodes[0].value = "Ei eelista";
	document.getElementById('tableCommitee-4-10').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-4-11').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-4-12').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-4-13').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-4-14').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-4-15').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-4-16').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-4-17').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-4-18').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-5-1').innerHTML = "Marko Kääramees";
	document.getElementById('tableCommitee-5-2').childNodes[0].value = "Doktor";
	document.getElementById('tableCommitee-5-3').childNodes[0].value = "Aseesimees";
	document.getElementById('tableCommitee-5-4').childNodes[0].value = "";
	document.getElementById('tableCommitee-5-5').childNodes[0].value = "";
	document.getElementById('tableCommitee-5-6').childNodes[0].value = "";
	document.getElementById('tableCommitee-5-7').childNodes[0].value = "";
	document.getElementById('tableCommitee-5-8').childNodes[0].value = "";
	document.getElementById('tableCommitee-5-9').childNodes[0].value = "";
	document.getElementById('tableCommitee-5-10').childNodes[0].value = "";
	document.getElementById('tableCommitee-5-11').childNodes[0].value = "";
	document.getElementById('tableCommitee-5-12').childNodes[0].value = "";
	document.getElementById('tableCommitee-5-13').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-5-14').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-5-15').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-5-16').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-5-17').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-5-18').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-6-1').innerHTML = "Monika Kreinin";
	document.getElementById('tableCommitee-6-2').childNodes[0].value = "Magister";
	document.getElementById('tableCommitee-6-3').childNodes[0].value = "Ei";
	document.getElementById('tableCommitee-6-4').childNodes[0].value = "";
	document.getElementById('tableCommitee-6-5').childNodes[0].value = "";
	document.getElementById('tableCommitee-6-6').childNodes[0].value = "";
	document.getElementById('tableCommitee-6-7').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-6-8').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-6-9').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-6-10').childNodes[0].value = "";
	document.getElementById('tableCommitee-6-11').childNodes[0].value = "";
	document.getElementById('tableCommitee-6-12').childNodes[0].value = "";
	document.getElementById('tableCommitee-6-13').childNodes[0].value = "";
	document.getElementById('tableCommitee-6-14').childNodes[0].value = "";
	document.getElementById('tableCommitee-6-15').childNodes[0].value = "";
	document.getElementById('tableCommitee-6-16').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-6-17').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-6-18').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-7-1').innerHTML = "Tarvo Treier";
	document.getElementById('tableCommitee-7-2').childNodes[0].value = "Magister";
	document.getElementById('tableCommitee-7-3').childNodes[0].value = "Ei";
	document.getElementById('tableCommitee-7-4').childNodes[0].value = "";
	document.getElementById('tableCommitee-7-5').childNodes[0].value = "";
	document.getElementById('tableCommitee-7-6').childNodes[0].value = "";
	document.getElementById('tableCommitee-7-7').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-7-8').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-7-9').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-7-10').childNodes[0].value = "";
	document.getElementById('tableCommitee-7-11').childNodes[0].value = "";
	document.getElementById('tableCommitee-7-12').childNodes[0].value = "";
	document.getElementById('tableCommitee-7-13').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-7-14').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-7-15').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-7-16').childNodes[0].value = "";
	document.getElementById('tableCommitee-7-17').childNodes[0].value = "";
	document.getElementById('tableCommitee-7-18').childNodes[0].value = "";
	document.getElementById('tableCommitee-8-1').innerHTML = "Commitee1";
	document.getElementById('tableCommitee-8-2').childNodes[0].value = "Magister";
	document.getElementById('tableCommitee-8-3').childNodes[0].value = "Ei";
	document.getElementById('tableCommitee-8-4').childNodes[0].value = "";
	document.getElementById('tableCommitee-8-5').childNodes[0].value = "";
	document.getElementById('tableCommitee-8-6').childNodes[0].value = "";
	document.getElementById('tableCommitee-8-7').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-8-8').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-8-9').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-8-10').childNodes[0].value = "";
	document.getElementById('tableCommitee-8-11').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-8-12').childNodes[0].value = "";
	document.getElementById('tableCommitee-8-13').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-8-14').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-8-15').childNodes[0].value = "Ei eelista";
	document.getElementById('tableCommitee-8-16').childNodes[0].value = "";
	document.getElementById('tableCommitee-8-17').childNodes[0].value = "";
	document.getElementById('tableCommitee-8-18').childNodes[0].value = "";
	document.getElementById('tableCommitee-9-1').innerHTML = "Commitee2";
	document.getElementById('tableCommitee-9-2').childNodes[0].value = "Magister";
	document.getElementById('tableCommitee-9-3').childNodes[0].value = "Ei";
	document.getElementById('tableCommitee-9-4').childNodes[0].value = "";
	document.getElementById('tableCommitee-9-5').childNodes[0].value = "";
	document.getElementById('tableCommitee-9-6').childNodes[0].value = "";
	document.getElementById('tableCommitee-9-7').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-9-8').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-9-9').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-9-10').childNodes[0].value = "";
	document.getElementById('tableCommitee-9-11').childNodes[0].value = "";
	document.getElementById('tableCommitee-9-12').childNodes[0].value = "";
	document.getElementById('tableCommitee-9-13').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-9-14').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-9-15').childNodes[0].value = "";
	document.getElementById('tableCommitee-9-16').childNodes[0].value = "";
	document.getElementById('tableCommitee-9-17').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-9-18').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-10-1').innerHTML = "Commitee3";
	document.getElementById('tableCommitee-10-2').childNodes[0].value = "Magister";
	document.getElementById('tableCommitee-10-3').childNodes[0].value = "Ei";
	document.getElementById('tableCommitee-10-4').childNodes[0].value = "";
	document.getElementById('tableCommitee-10-5').childNodes[0].value = "";
	document.getElementById('tableCommitee-10-6').childNodes[0].value = "";
	document.getElementById('tableCommitee-10-7').childNodes[0].value = "";
	document.getElementById('tableCommitee-10-8').childNodes[0].value = "";
	document.getElementById('tableCommitee-10-9').childNodes[0].value = "";
	document.getElementById('tableCommitee-10-10').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-10-11').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-10-12').childNodes[0].value = "Ei sobi";
	document.getElementById('tableCommitee-10-13').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-10-14').childNodes[0].value = "Eelistab";
	document.getElementById('tableCommitee-10-15').childNodes[0].value = "";
	document.getElementById('tableCommitee-10-16').childNodes[0].value = "";
	document.getElementById('tableCommitee-10-17').childNodes[0].value = "";
	document.getElementById('tableCommitee-10-18').childNodes[0].value = "";
}

function generateDefenseTable(){
	document.getElementById('tableDefense-1-1').innerHTML = "Kood";
	document.getElementById('tableDefense-1-2').innerHTML = "Lõputöö pealkiri";
	document.getElementById('tableDefense-1-3').innerHTML = "Kaitsmise tüüp";
	document.getElementById('tableDefense-1-4').innerHTML = "Lõputöö kraad";
	document.getElementById('tableDefense-1-5').innerHTML = "Lõputöö autor";
	document.getElementById('tableDefense-1-6').innerHTML = "Sarnane lõputöö teema";
	document.getElementById('tableDefense-1-7').innerHTML = "Ruumi nr";
	document.getElementById('tableDefense-1-8').innerHTML = "Ruumi maht";
	document.getElementById('tableDefense-1-9').innerHTML = "Komisjoni suurus";
	document.getElementById('tableDefense-2-1').innerHTML = "D001";
	document.getElementById('tableDefense-2-2').innerHTML = "Lõputööde kaitsmiste ajakava koostamine kasutades OptaPlannerit";
	document.getElementById('tableDefense-2-3').childNodes[0].value = "Lahtine";
	document.getElementById('tableDefense-2-4').childNodes[0].value = "Bakalaureus";
	document.getElementById('tableDefense-2-5').childNodes[0].value = "Roald Välja";
	document.getElementById('tableDefense-2-6').innerHTML = "";
	document.getElementById('tableDefense-2-7').innerHTML = "ICT-410";
	document.getElementById('tableDefense-2-8').childNodes[0].value = "20";
	document.getElementById('tableDefense-2-9').childNodes[0].value = "3";
	document.getElementById('tableDefense-3-1').innerHTML = "D002";
	document.getElementById('tableDefense-3-2').innerHTML = "Kõnnaku analüüs isiku tuvastamiseks";
	document.getElementById('tableDefense-3-3').childNodes[0].value = "Lahtine";
	document.getElementById('tableDefense-3-4').childNodes[0].value = "Bakalaureus";
	document.getElementById('tableDefense-3-5').childNodes[0].value = "Tom Smith";
	document.getElementById('tableDefense-3-6').innerHTML = "";
	document.getElementById('tableDefense-3-7').innerHTML = "ICT-410";
	document.getElementById('tableDefense-3-8').childNodes[0].value = "20";
	document.getElementById('tableDefense-3-9').childNodes[0].value = "3";
	document.getElementById('tableDefense-4-1').innerHTML = "D003";
	document.getElementById('tableDefense-4-2').innerHTML = "Maastikumänge toetav Mobiilirakendus";
	document.getElementById('tableDefense-4-3').childNodes[0].value = "Lahtine";
	document.getElementById('tableDefense-4-4').childNodes[0].value = "Bakalaureus";
	document.getElementById('tableDefense-4-5').childNodes[0].value = "Ami Hennig";
	document.getElementById('tableDefense-4-6').innerHTML = "";
	document.getElementById('tableDefense-4-7').innerHTML = "ICT-410";
	document.getElementById('tableDefense-4-8').childNodes[0].value = "20";
	document.getElementById('tableDefense-4-9').childNodes[0].value = "3";
	document.getElementById('tableDefense-5-1').innerHTML = "D004";
	document.getElementById('tableDefense-5-2').innerHTML = "Voxel Game Engine Using Blender Game Engine";
	document.getElementById('tableDefense-5-3').childNodes[0].value = "Lahtine";
	document.getElementById('tableDefense-5-4').childNodes[0].value = "Bakalaureus";
	document.getElementById('tableDefense-5-5').childNodes[0].value = "Kairi Luts";
	document.getElementById('tableDefense-5-6').innerHTML = "";
	document.getElementById('tableDefense-5-7').innerHTML = "ICT-410";
	document.getElementById('tableDefense-5-8').childNodes[0].value = "20";
	document.getElementById('tableDefense-5-9').childNodes[0].value = "3";
	document.getElementById('tableDefense-6-1').innerHTML = "D005";
	document.getElementById('tableDefense-6-2').innerHTML = "Ristmiku kinnisõitmise ennustamine fooritsükli optimeerimiseks";
	document.getElementById('tableDefense-6-3').childNodes[0].value = "Lahtine";
	document.getElementById('tableDefense-6-4').childNodes[0].value = "Bakalaureus";
	document.getElementById('tableDefense-6-5').childNodes[0].value = "Mihkel Roomets";
	document.getElementById('tableDefense-6-6').innerHTML = "";
	document.getElementById('tableDefense-6-7').innerHTML = "ICT-410";
	document.getElementById('tableDefense-6-8').childNodes[0].value = "20";
	document.getElementById('tableDefense-6-9').childNodes[0].value = "3";
	document.getElementById('tableDefense-7-1').innerHTML = "D006";
	document.getElementById('tableDefense-7-2').innerHTML = "An Alternative Approach for Gait Analysis of Parkinson’s Disease Patients";
	document.getElementById('tableDefense-7-3').childNodes[0].value = "Kinnine";
	document.getElementById('tableDefense-7-4').childNodes[0].value = "Bakalaureus";
	document.getElementById('tableDefense-7-5').childNodes[0].value = "Karl Loopuu";
	document.getElementById('tableDefense-7-6').innerHTML = "";
	document.getElementById('tableDefense-7-7').innerHTML = "ICT-410";
	document.getElementById('tableDefense-7-8').childNodes[0].value = "20";
	document.getElementById('tableDefense-7-9').childNodes[0].value = "3";
	document.getElementById('tableDefense-8-1').innerHTML = "D007";
	document.getElementById('tableDefense-8-2').innerHTML = "Solving the Tartarus Problem by Means of Genetic Algorithms";
	document.getElementById('tableDefense-8-3').childNodes[0].value = "Lahtine";
	document.getElementById('tableDefense-8-4').childNodes[0].value = "Bakalaureus";
	document.getElementById('tableDefense-8-5').childNodes[0].value = "Kelli Tulp";
	document.getElementById('tableDefense-8-6').innerHTML = "";
	document.getElementById('tableDefense-8-7').innerHTML = "ICT-410";
	document.getElementById('tableDefense-8-8').childNodes[0].value = "20";
	document.getElementById('tableDefense-8-9').childNodes[0].value = "3";
	document.getElementById('tableDefense-9-1').innerHTML = "D008";
	document.getElementById('tableDefense-9-2').innerHTML = "Linnworks System Status Monitoring";
	document.getElementById('tableDefense-9-3').childNodes[0].value = "Lahtine";
	document.getElementById('tableDefense-9-4').childNodes[0].value = "Bakalaureus";
	document.getElementById('tableDefense-9-5').childNodes[0].value = "Andres Suursoo";
	document.getElementById('tableDefense-9-6').innerHTML = "";
	document.getElementById('tableDefense-9-7').innerHTML = "ICT-410";
	document.getElementById('tableDefense-9-8').childNodes[0].value = "20";
	document.getElementById('tableDefense-9-9').childNodes[0].value = "3";
}

function generateTimeslotTableTemplate(){
	document.getElementById('tableTimeslot-1-1').innerHTML = "Päev";
	document.getElementById('tableTimeslot-1-2').innerHTML = "Algus";
	document.getElementById('tableTimeslot-1-3').innerHTML = "Lõpp";
	document.getElementById('tableTimeslot-1-4').innerHTML = "Kaitsmise tüüp";
	document.getElementById('tableTimeslot-1-5').innerHTML = "Sessioon";
	document.getElementById('tableTimeslot-1-6').innerHTML = "Võtmesõnad";
	document.getElementById('tableTimeslot-2-1').innerHTML = "";
	document.getElementById('tableTimeslot-2-2').innerHTML = "";
	document.getElementById('tableTimeslot-2-3').innerHTML = "";
	document.getElementById('tableTimeslot-2-4').innerHTML = "";
	document.getElementById('tableTimeslot-2-5').innerHTML = "";
	document.getElementById('tableTimeslot-2-6').innerHTML = "";
	document.getElementById('tableTimeslot-3-1').innerHTML = "";
	document.getElementById('tableTimeslot-3-2').innerHTML = "";
	document.getElementById('tableTimeslot-3-3').innerHTML = "";
	document.getElementById('tableTimeslot-3-4').innerHTML = "";
	document.getElementById('tableTimeslot-3-5').innerHTML = "";
	document.getElementById('tableTimeslot-3-6').innerHTML = "";
	document.getElementById('tableTimeslot-4-1').innerHTML = "";
	document.getElementById('tableTimeslot-4-2').innerHTML = "";
	document.getElementById('tableTimeslot-4-3').innerHTML = "";
	document.getElementById('tableTimeslot-4-4').innerHTML = "";
	document.getElementById('tableTimeslot-4-5').innerHTML = "";
	document.getElementById('tableTimeslot-4-6').innerHTML = "";
	document.getElementById('tableTimeslot-5-1').innerHTML = "";
	document.getElementById('tableTimeslot-5-2').innerHTML = "";
	document.getElementById('tableTimeslot-5-3').innerHTML = "";
	document.getElementById('tableTimeslot-5-4').innerHTML = "";
	document.getElementById('tableTimeslot-5-5').innerHTML = "";
	document.getElementById('tableTimeslot-5-6').innerHTML = "";
	document.getElementById('tableTimeslot-6-1').innerHTML = "";
	document.getElementById('tableTimeslot-6-2').innerHTML = "";
	document.getElementById('tableTimeslot-6-3').innerHTML = "";
	document.getElementById('tableTimeslot-6-4').innerHTML = "";
	document.getElementById('tableTimeslot-6-5').innerHTML = "";
	document.getElementById('tableTimeslot-6-6').innerHTML = "";
}

function generateAuthorTableTemplate(){
	document.getElementById('tableAuthor-1-1').innerHTML = "";
	document.getElementById('tableAuthor-1-2').innerHTML = "";
	document.getElementById('tableAuthor-1-3').innerHTML = "";
	document.getElementById('tableAuthor-1-4').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-5').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-6').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-7').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-8').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-9').innerHTML = "03.06.2019";
	document.getElementById('tableAuthor-1-10').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-1-11').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-1-12').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-1-13').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-1-14').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-1-15').innerHTML = "04.06.2019";
	document.getElementById('tableAuthor-2-1').innerHTML = "Nimi";
	document.getElementById('tableAuthor-2-2').innerHTML = "Eeldused on täidetud";
	document.getElementById('tableAuthor-2-3').innerHTML = "Juhendajad";
	document.getElementById('tableAuthor-2-4').innerHTML = "09:00-09:20";
	document.getElementById('tableAuthor-2-5').innerHTML = "09:20-09:40";
	document.getElementById('tableAuthor-2-6').innerHTML = "09:40-10:00";
	document.getElementById('tableAuthor-2-7').innerHTML = "10:20-10:40";
	document.getElementById('tableAuthor-2-8').innerHTML = "10:40-11:00";
	document.getElementById('tableAuthor-2-9').innerHTML = "11:00-11:20";
	document.getElementById('tableAuthor-2-10').innerHTML = "09:00-09:20";
	document.getElementById('tableAuthor-2-11').innerHTML = "09:20-09:40";
	document.getElementById('tableAuthor-2-12').innerHTML = "09:40-10:00";
	document.getElementById('tableAuthor-2-13').innerHTML = "10:20-10:40";
	document.getElementById('tableAuthor-2-14').innerHTML = "10:40-11:00";
	document.getElementById('tableAuthor-2-15').innerHTML = "11:00-11:20";
	document.getElementById('tableAuthor-3-1').innerHTML = "";
	document.getElementById('tableAuthor-3-2').innerHTML = "";
	document.getElementById('tableAuthor-3-3').innerHTML = "";
	document.getElementById('tableAuthor-3-4').innerHTML = "";
	document.getElementById('tableAuthor-3-5').innerHTML = "";
	document.getElementById('tableAuthor-3-6').innerHTML = "";
	document.getElementById('tableAuthor-3-7').innerHTML = "";
	document.getElementById('tableAuthor-3-8').innerHTML = "";
	document.getElementById('tableAuthor-3-9').innerHTML = "";
	document.getElementById('tableAuthor-3-10').innerHTML = "";
	document.getElementById('tableAuthor-3-11').innerHTML = "";
	document.getElementById('tableAuthor-3-12').innerHTML = "";
	document.getElementById('tableAuthor-3-13').innerHTML = "";
	document.getElementById('tableAuthor-3-14').innerHTML = "";
	document.getElementById('tableAuthor-3-15').innerHTML = "";	
	document.getElementById('tableAuthor-4-1').innerHTML = "";
	document.getElementById('tableAuthor-4-2').innerHTML = "";
	document.getElementById('tableAuthor-4-3').innerHTML = "";
	document.getElementById('tableAuthor-4-4').innerHTML = "";
	document.getElementById('tableAuthor-4-5').innerHTML = "";
	document.getElementById('tableAuthor-4-6').innerHTML = "";
	document.getElementById('tableAuthor-4-7').innerHTML = "";
	document.getElementById('tableAuthor-4-8').innerHTML = "";
	document.getElementById('tableAuthor-4-9').innerHTML = "";
	document.getElementById('tableAuthor-4-10').innerHTML = "";
	document.getElementById('tableAuthor-4-11').innerHTML = "";
	document.getElementById('tableAuthor-4-12').innerHTML = "";
	document.getElementById('tableAuthor-4-13').innerHTML = "";
	document.getElementById('tableAuthor-4-14').innerHTML = "";
	document.getElementById('tableAuthor-4-15').innerHTML = "";	
	document.getElementById('tableAuthor-5-1').innerHTML = "";
	document.getElementById('tableAuthor-5-2').innerHTML = "";
	document.getElementById('tableAuthor-5-3').innerHTML = "";
	document.getElementById('tableAuthor-5-4').innerHTML = "";
	document.getElementById('tableAuthor-5-5').innerHTML = "";
	document.getElementById('tableAuthor-5-6').innerHTML = "";
	document.getElementById('tableAuthor-5-7').innerHTML = "";
	document.getElementById('tableAuthor-5-8').innerHTML = "";
	document.getElementById('tableAuthor-5-9').innerHTML = "";
	document.getElementById('tableAuthor-5-10').innerHTML = "";
	document.getElementById('tableAuthor-5-11').innerHTML = "";
	document.getElementById('tableAuthor-5-12').innerHTML = "";
	document.getElementById('tableAuthor-5-13').innerHTML = "";
	document.getElementById('tableAuthor-5-14').innerHTML = "";
	document.getElementById('tableAuthor-5-15').innerHTML = "";	
	document.getElementById('tableAuthor-6-1').innerHTML = "";
	document.getElementById('tableAuthor-6-2').innerHTML = "";
	document.getElementById('tableAuthor-6-3').innerHTML = "";
	document.getElementById('tableAuthor-6-4').innerHTML = "";
	document.getElementById('tableAuthor-6-5').innerHTML = "";
	document.getElementById('tableAuthor-6-6').innerHTML = "";
	document.getElementById('tableAuthor-6-7').innerHTML = "";
	document.getElementById('tableAuthor-6-8').innerHTML = "";
	document.getElementById('tableAuthor-6-9').innerHTML = "";
	document.getElementById('tableAuthor-6-10').innerHTML = "";
	document.getElementById('tableAuthor-6-11').innerHTML = "";
	document.getElementById('tableAuthor-6-12').innerHTML = "";
	document.getElementById('tableAuthor-6-13').innerHTML = "";
	document.getElementById('tableAuthor-6-14').innerHTML = "";
	document.getElementById('tableAuthor-6-15').innerHTML = "";	
	document.getElementById('tableAuthor-7-1').innerHTML = "";
	document.getElementById('tableAuthor-7-2').innerHTML = "";
	document.getElementById('tableAuthor-7-3').innerHTML = "";
	document.getElementById('tableAuthor-7-4').innerHTML = "";
	document.getElementById('tableAuthor-7-5').innerHTML = "";
	document.getElementById('tableAuthor-7-6').innerHTML = "";
	document.getElementById('tableAuthor-7-7').innerHTML = "";
	document.getElementById('tableAuthor-7-8').innerHTML = "";
	document.getElementById('tableAuthor-7-9').innerHTML = "";
	document.getElementById('tableAuthor-7-10').innerHTML = "";
	document.getElementById('tableAuthor-7-11').innerHTML = "";
	document.getElementById('tableAuthor-7-12').innerHTML = "";
	document.getElementById('tableAuthor-7-13').innerHTML = "";
	document.getElementById('tableAuthor-7-14').innerHTML = "";
	document.getElementById('tableAuthor-7-15').innerHTML = "";
}

function generateSupervisorTableTemplate(){
	document.getElementById('tableSupervisor-1-1').innerHTML = "";
	document.getElementById('tableSupervisor-1-2').innerHTML = "";
	document.getElementById('tableSupervisor-1-3').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-4').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-5').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-6').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-7').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-8').innerHTML = "03.06.2019";
	document.getElementById('tableSupervisor-1-9').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-1-10').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-1-11').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-1-12').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-1-13').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-1-14').innerHTML = "04.06.2019";
	document.getElementById('tableSupervisor-2-1').innerHTML = "Nimi";
	document.getElementById('tableSupervisor-2-2').innerHTML = "Roll";
	document.getElementById('tableSupervisor-2-3').innerHTML = "09:00-09:20";
	document.getElementById('tableSupervisor-2-4').innerHTML = "09:20-09:40";
	document.getElementById('tableSupervisor-2-5').innerHTML = "09:40-10:00";
	document.getElementById('tableSupervisor-2-6').innerHTML = "10:20-10:40";
	document.getElementById('tableSupervisor-2-7').innerHTML = "10:40-11:00";
	document.getElementById('tableSupervisor-2-8').innerHTML = "11:00-11:20";
	document.getElementById('tableSupervisor-2-9').innerHTML = "09:00-09:20";
	document.getElementById('tableSupervisor-2-10').innerHTML = "09:20-09:40";
	document.getElementById('tableSupervisor-2-11').innerHTML = "09:40-10:00";
	document.getElementById('tableSupervisor-2-12').innerHTML = "10:20-10:40";
	document.getElementById('tableSupervisor-2-13').innerHTML = "10:40-11:00";
	document.getElementById('tableSupervisor-2-14').innerHTML = "11:00-11:20";
	document.getElementById('tableSupervisor-3-1').innerHTML = "";
	document.getElementById('tableSupervisor-3-2').innerHTML = "";
	document.getElementById('tableSupervisor-3-3').innerHTML = "";
	document.getElementById('tableSupervisor-3-4').innerHTML = "";
	document.getElementById('tableSupervisor-3-5').innerHTML = "";
	document.getElementById('tableSupervisor-3-6').innerHTML = "";
	document.getElementById('tableSupervisor-3-7').innerHTML = "";
	document.getElementById('tableSupervisor-3-8').innerHTML = "";
	document.getElementById('tableSupervisor-3-9').innerHTML = "";
	document.getElementById('tableSupervisor-3-10').innerHTML = "";
	document.getElementById('tableSupervisor-3-11').innerHTML = "";
	document.getElementById('tableSupervisor-3-12').innerHTML = "";
	document.getElementById('tableSupervisor-3-13').innerHTML = "";
	document.getElementById('tableSupervisor-3-14').innerHTML = "";
	document.getElementById('tableSupervisor-4-1').innerHTML = "";
	document.getElementById('tableSupervisor-4-2').innerHTML = "";
	document.getElementById('tableSupervisor-4-3').innerHTML = "";
	document.getElementById('tableSupervisor-4-4').innerHTML = "";
	document.getElementById('tableSupervisor-4-5').innerHTML = "";
	document.getElementById('tableSupervisor-4-6').innerHTML = "";
	document.getElementById('tableSupervisor-4-7').innerHTML = "";
	document.getElementById('tableSupervisor-4-8').innerHTML = "";
	document.getElementById('tableSupervisor-4-9').innerHTML = "";
	document.getElementById('tableSupervisor-4-10').innerHTML = "";
	document.getElementById('tableSupervisor-4-11').innerHTML = "";
	document.getElementById('tableSupervisor-4-12').innerHTML = "";
	document.getElementById('tableSupervisor-4-13').innerHTML = "";
	document.getElementById('tableSupervisor-4-14').innerHTML = "";
	document.getElementById('tableSupervisor-5-1').innerHTML = "";
	document.getElementById('tableSupervisor-5-2').innerHTML = "";
	document.getElementById('tableSupervisor-5-3').innerHTML = "";
	document.getElementById('tableSupervisor-5-4').innerHTML = "";
	document.getElementById('tableSupervisor-5-5').innerHTML = "";
	document.getElementById('tableSupervisor-5-6').innerHTML = "";
	document.getElementById('tableSupervisor-5-7').innerHTML = "";
	document.getElementById('tableSupervisor-5-8').innerHTML = "";
	document.getElementById('tableSupervisor-5-9').innerHTML = "";
	document.getElementById('tableSupervisor-5-10').innerHTML = "";
	document.getElementById('tableSupervisor-5-11').innerHTML = "";
	document.getElementById('tableSupervisor-5-12').innerHTML = "";
	document.getElementById('tableSupervisor-5-13').innerHTML = "";
	document.getElementById('tableSupervisor-5-14').innerHTML = "";
	document.getElementById('tableSupervisor-6-1').innerHTML = "";
	document.getElementById('tableSupervisor-6-2').innerHTML = "";
	document.getElementById('tableSupervisor-6-3').innerHTML = "";
	document.getElementById('tableSupervisor-6-4').innerHTML = "";
	document.getElementById('tableSupervisor-6-5').innerHTML = "";
	document.getElementById('tableSupervisor-6-6').innerHTML = "";
	document.getElementById('tableSupervisor-6-7').innerHTML = "";
	document.getElementById('tableSupervisor-6-8').innerHTML = "";
	document.getElementById('tableSupervisor-6-9').innerHTML = "";
	document.getElementById('tableSupervisor-6-10').innerHTML = "";
	document.getElementById('tableSupervisor-6-11').innerHTML = "";
	document.getElementById('tableSupervisor-6-12').innerHTML = "";
	document.getElementById('tableSupervisor-6-13').innerHTML = "";
	document.getElementById('tableSupervisor-6-14').innerHTML = "";
	document.getElementById('tableSupervisor-7-1').innerHTML = "";
	document.getElementById('tableSupervisor-7-2').innerHTML = "";
	document.getElementById('tableSupervisor-7-3').innerHTML = "";
	document.getElementById('tableSupervisor-7-4').innerHTML = "";
	document.getElementById('tableSupervisor-7-5').innerHTML = "";
	document.getElementById('tableSupervisor-7-6').innerHTML = "";
	document.getElementById('tableSupervisor-7-7').innerHTML = "";
	document.getElementById('tableSupervisor-7-8').innerHTML = "";
	document.getElementById('tableSupervisor-7-9').innerHTML = "";
	document.getElementById('tableSupervisor-7-10').innerHTML = "";
	document.getElementById('tableSupervisor-7-11').innerHTML = "";
	document.getElementById('tableSupervisor-7-12').innerHTML = "";
	document.getElementById('tableSupervisor-7-13').innerHTML = "";
	document.getElementById('tableSupervisor-7-14').innerHTML = "";
}

function generateCommiteeTableTemplate(){
	document.getElementById('tableCommitee-1-1').innerHTML = "";
	document.getElementById('tableCommitee-1-2').innerHTML = "";
	document.getElementById('tableCommitee-1-3').innerHTML = "";
	document.getElementById('tableCommitee-1-4').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-5').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-6').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-7').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-8').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-9').innerHTML = "03.06.2019";
	document.getElementById('tableCommitee-1-10').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-1-11').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-1-12').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-1-13').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-1-14').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-1-15').innerHTML = "04.06.2019";
	document.getElementById('tableCommitee-2-1').innerHTML = "Nimi";
	document.getElementById('tableCommitee-2-2').innerHTML = "Kraad";
	document.getElementById('tableCommitee-2-3').innerHTML = "Esimees";
	document.getElementById('tableCommitee-2-4').innerHTML = "09:00-09:20";
	document.getElementById('tableCommitee-2-5').innerHTML = "09:20-09:40";
	document.getElementById('tableCommitee-2-6').innerHTML = "09:40-10:00";
	document.getElementById('tableCommitee-2-7').innerHTML = "10:20-10:40";
	document.getElementById('tableCommitee-2-8').innerHTML = "10:40-11:00";
	document.getElementById('tableCommitee-2-9').innerHTML = "11:00-11:20";
	document.getElementById('tableCommitee-2-10').innerHTML = "09:00-09:20";
	document.getElementById('tableCommitee-2-11').innerHTML = "09:20-09:40";
	document.getElementById('tableCommitee-2-12').innerHTML = "09:40-10:00";
	document.getElementById('tableCommitee-2-13').innerHTML = "10:20-10:40";
	document.getElementById('tableCommitee-2-14').innerHTML = "10:40-11:00";
	document.getElementById('tableCommitee-2-15').innerHTML = "11:00-11:20";
	document.getElementById('tableCommitee-3-1').innerHTML = "";
	document.getElementById('tableCommitee-3-2').innerHTML = "";
	document.getElementById('tableCommitee-3-3').innerHTML = "";
	document.getElementById('tableCommitee-3-4').innerHTML = "";
	document.getElementById('tableCommitee-3-5').innerHTML = "";
	document.getElementById('tableCommitee-3-6').innerHTML = "";
	document.getElementById('tableCommitee-3-7').innerHTML = "";
	document.getElementById('tableCommitee-3-8').innerHTML = "";
	document.getElementById('tableCommitee-3-9').innerHTML = "";
	document.getElementById('tableCommitee-3-10').innerHTML = "";
	document.getElementById('tableCommitee-3-11').innerHTML = "";
	document.getElementById('tableCommitee-3-12').innerHTML = "";
	document.getElementById('tableCommitee-3-13').innerHTML = "";
	document.getElementById('tableCommitee-3-14').innerHTML = "";
	document.getElementById('tableCommitee-3-15').innerHTML = "";
	document.getElementById('tableCommitee-4-1').innerHTML = "";
	document.getElementById('tableCommitee-4-2').innerHTML = "";
	document.getElementById('tableCommitee-4-3').innerHTML = "";
	document.getElementById('tableCommitee-4-4').innerHTML = "";
	document.getElementById('tableCommitee-4-5').innerHTML = "";
	document.getElementById('tableCommitee-4-6').innerHTML = "";
	document.getElementById('tableCommitee-4-7').innerHTML = "";
	document.getElementById('tableCommitee-4-8').innerHTML = "";
	document.getElementById('tableCommitee-4-9').innerHTML = "";
	document.getElementById('tableCommitee-4-10').innerHTML = "";
	document.getElementById('tableCommitee-4-11').innerHTML = "";
	document.getElementById('tableCommitee-4-12').innerHTML = "";
	document.getElementById('tableCommitee-4-13').innerHTML = "";
	document.getElementById('tableCommitee-4-14').innerHTML = "";
	document.getElementById('tableCommitee-4-15').innerHTML = "";
	document.getElementById('tableCommitee-5-1').innerHTML = "";
	document.getElementById('tableCommitee-5-2').innerHTML = "";
	document.getElementById('tableCommitee-5-3').innerHTML = "";
	document.getElementById('tableCommitee-5-4').innerHTML = "";
	document.getElementById('tableCommitee-5-5').innerHTML = "";
	document.getElementById('tableCommitee-5-6').innerHTML = "";
	document.getElementById('tableCommitee-5-7').innerHTML = "";
	document.getElementById('tableCommitee-5-8').innerHTML = "";
	document.getElementById('tableCommitee-5-9').innerHTML = "";
	document.getElementById('tableCommitee-5-10').innerHTML = "";
	document.getElementById('tableCommitee-5-11').innerHTML = "";
	document.getElementById('tableCommitee-5-12').innerHTML = "";
	document.getElementById('tableCommitee-5-13').innerHTML = "";
	document.getElementById('tableCommitee-5-14').innerHTML = "";
	document.getElementById('tableCommitee-5-15').innerHTML = "";
	document.getElementById('tableCommitee-6-1').innerHTML = "";
	document.getElementById('tableCommitee-6-2').innerHTML = "";
	document.getElementById('tableCommitee-6-3').innerHTML = "";
	document.getElementById('tableCommitee-6-4').innerHTML = "";
	document.getElementById('tableCommitee-6-5').innerHTML = "";
	document.getElementById('tableCommitee-6-6').innerHTML = "";
	document.getElementById('tableCommitee-6-7').innerHTML = "";
	document.getElementById('tableCommitee-6-8').innerHTML = "";
	document.getElementById('tableCommitee-6-9').innerHTML = "";
	document.getElementById('tableCommitee-6-10').innerHTML = "";
	document.getElementById('tableCommitee-6-11').innerHTML = "";
	document.getElementById('tableCommitee-6-12').innerHTML = "";
	document.getElementById('tableCommitee-6-13').innerHTML = "";
	document.getElementById('tableCommitee-6-14').innerHTML = "";
	document.getElementById('tableCommitee-6-15').innerHTML = "";
	document.getElementById('tableCommitee-7-1').innerHTML = "";
	document.getElementById('tableCommitee-7-2').innerHTML = "";
	document.getElementById('tableCommitee-7-3').innerHTML = "";
	document.getElementById('tableCommitee-7-4').innerHTML = "";
	document.getElementById('tableCommitee-7-5').innerHTML = "";
	document.getElementById('tableCommitee-7-6').innerHTML = "";
	document.getElementById('tableCommitee-7-7').innerHTML = "";
	document.getElementById('tableCommitee-7-8').innerHTML = "";
	document.getElementById('tableCommitee-7-9').innerHTML = "";
	document.getElementById('tableCommitee-7-10').innerHTML = "";
	document.getElementById('tableCommitee-7-11').innerHTML = "";
	document.getElementById('tableCommitee-7-12').innerHTML = "";
	document.getElementById('tableCommitee-7-13').innerHTML = "";
	document.getElementById('tableCommitee-7-14').innerHTML = "";
	document.getElementById('tableCommitee-7-15').innerHTML = "";
}

function generateDefenseTableTemplate(){
	document.getElementById('tableDefense-1-1').innerHTML = "Kood";
	document.getElementById('tableDefense-1-2').innerHTML = "Lõputöö pealkiri";
	document.getElementById('tableDefense-1-3').innerHTML = "Kaitsmise tüüp";
	document.getElementById('tableDefense-1-4').innerHTML = "Lõputöö kraad";
	document.getElementById('tableDefense-1-5').innerHTML = "Lõputöö autor";
	document.getElementById('tableDefense-1-6').innerHTML = "Sarnane lõputöö teema";
	document.getElementById('tableDefense-1-7').innerHTML = "Ruumi nr";
	document.getElementById('tableDefense-1-8').innerHTML = "Ruumi maht";
	document.getElementById('tableDefense-1-9').innerHTML = "Komisjoni suurus";
	document.getElementById('tableDefense-2-1').innerHTML = "";
	document.getElementById('tableDefense-2-2').innerHTML = "";
	document.getElementById('tableDefense-2-3').innerHTML = "";
	document.getElementById('tableDefense-2-4').innerHTML = "";
	document.getElementById('tableDefense-2-5').innerHTML = "";
	document.getElementById('tableDefense-2-6').innerHTML = "";
	document.getElementById('tableDefense-2-7').innerHTML = "";
	document.getElementById('tableDefense-2-8').innerHTML = "";
	document.getElementById('tableDefense-2-9').innerHTML = "";
	document.getElementById('tableDefense-3-1').innerHTML = "";
	document.getElementById('tableDefense-3-2').innerHTML = "";
	document.getElementById('tableDefense-3-3').innerHTML = "";
	document.getElementById('tableDefense-3-4').innerHTML = "";
	document.getElementById('tableDefense-3-5').innerHTML = "";
	document.getElementById('tableDefense-3-6').innerHTML = "";
	document.getElementById('tableDefense-3-7').innerHTML = "";
	document.getElementById('tableDefense-3-8').innerHTML = "";
	document.getElementById('tableDefense-3-9').innerHTML = "";
	document.getElementById('tableDefense-4-1').innerHTML = "";
	document.getElementById('tableDefense-4-2').innerHTML = "";
	document.getElementById('tableDefense-4-3').innerHTML = "";
	document.getElementById('tableDefense-4-4').innerHTML = "";
	document.getElementById('tableDefense-4-5').innerHTML = "";
	document.getElementById('tableDefense-4-6').innerHTML = "";
	document.getElementById('tableDefense-4-7').innerHTML = "";
	document.getElementById('tableDefense-4-8').innerHTML = "";
	document.getElementById('tableDefense-4-9').innerHTML = "";
	document.getElementById('tableDefense-5-1').innerHTML = "";
	document.getElementById('tableDefense-5-2').innerHTML = "";
	document.getElementById('tableDefense-5-3').innerHTML = "";
	document.getElementById('tableDefense-5-4').innerHTML = "";
	document.getElementById('tableDefense-5-5').innerHTML = "";
	document.getElementById('tableDefense-5-6').innerHTML = "";
	document.getElementById('tableDefense-5-7').innerHTML = "";
	document.getElementById('tableDefense-5-8').innerHTML = "";
	document.getElementById('tableDefense-5-9').innerHTML = "";
	document.getElementById('tableDefense-6-1').innerHTML = "";
	document.getElementById('tableDefense-6-2').innerHTML = "";
	document.getElementById('tableDefense-6-3').innerHTML = "";
	document.getElementById('tableDefense-6-4').innerHTML = "";
	document.getElementById('tableDefense-6-5').innerHTML = "";
	document.getElementById('tableDefense-6-6').innerHTML = "";
	document.getElementById('tableDefense-6-7').innerHTML = "";
	document.getElementById('tableDefense-6-8').innerHTML = "";
	document.getElementById('tableDefense-6-9').innerHTML = "";
}

