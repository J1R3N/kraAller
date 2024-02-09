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

1. Branch-Protection
--------------------
Settings - Branches - Add rule
	- Branch name pattern: main
	- require pull request reviews before merging 
	- 2 Reviewer
	
2. Aufgaben werden als Issue erfasst. 
--------------------------------------
	Namen beginnt mit einer forlaufenden Nummer
	Aufgabe wird einem Bearbeiter zugewiesen (Assignees)

3. Wenn eine Aufgabe bearbeitet wird
-------------------------------------
	- wird aus dem main-Branch ein Feature-Branch erstellt
	- Der Feature-Branch bekommt den Namen "feature/"+<name der Issue>
	
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
4. Wenn noch Zeit ist: selbst entwickeln
