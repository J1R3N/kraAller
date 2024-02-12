# kraAller
Krankenhaus-Allergen Auskunft

<h1>Allergenauskunft für Krankenhäuser</h1>
<br />
<ul>
<b>Teamleiter: </b>JusL
</ul>
<ul>
<b>GUI: </b> JusL & JohT
</ul>
<ul>
<b>Backend: </b> RobR 
</ul>
<ul>
<b>Tester: </b> ALLE (primär JohH) </b>
</ul>
<br /><br />
<p><b>Idee:</b>&nbsp; Für alle Krankenhäuser soll ein Allergenauskunft per Tabletsoftware (mit GUI) für das gesamte Haus zur Verfügung stellen.<br />
<b>Beispiel:</b>&nbsp;Patient A in Etage 4 Raum 33b, hat eine Allergie auf Milchprodukte und auf Erdnüssen, dh. die Krankenschwestern werden keine Gerichte von dieser Allergenklasse aus der Kantine zu den Patienten gebracht.</p>
<b>Eingesetze Technologien: </b><br />
<li>REST</li>
<li>GUI</li>
<li>SQLite (für die Datenbank)</li>



WorkFlow
=========

1. Branch-Protection (geht nur bei Pro)
---------------------------------------
Settings - Branches - Add rule
	- Branch name pattern: main
	- require pull request reviews before merging 
	- 2 Reviewer
	
2. Aufgaben werden als Issue erfasst. 
--------------------------------------
	Aufgabe wird einem Bearbeiter zugewiesen (Assignees)

3. Wenn eine Aufgabe bearbeitet wird
-------------------------------------
	- wird aus dem main-Branch ein Feature-Branch erstellt
	- Der Feature-Branch bekommt den Namen "feature/<ProjektKürzel>-<Nr der Issue>-<Name der Issue>"
	    Beispiel:
	        Das Projekt hat das Kürzel: "PRO"
	        Die Issue heißt: "JUnit-Test für KundenService" und hat die Nummer #23
	        dann heißt der Branch:
	        "feature/PRO-23-JUnit-Test-fuer-KundenService"
	        (Keine Umlaute und keine Leerzeichen)
	- Jede Commit-Message enthält die Nummer der Issue
	    Beispiel:
	        PRO-23
	        GoodDay-Szenario für neuen Kunden getestet

4. Wenn die Aufgabe	fertig ist
------------------------------
	- wird ein PullRequest (PR) vom Feature-Branch zum main-Branch erstellt
	- Als Reviewer werde ich und der Teamleiter eingetragen.
	- Sofern der Quelltext vom Teamleiter kommt, kann er einen Vertreter bestimmen
	
5. 	Erst wenn der PR genehmigt und gemerged ist 
------------------------------------------------
	- wird der Issue geschlossen.
	- der Feature-Branch gelöscht
	
Job des Team-/Projektleiters:
-----------------------------
1. Teammitglieder unterstützen
2. Dafür Sorgen, das die Teammitglieder zu tun haben
3. Dafür Sorgen, dass die administrativen Vorgaben (s.o.) erfüllt sind
4. wenn noch Zeit ist: selbst entwickeln
