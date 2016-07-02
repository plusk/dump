//Passer på at ingenting kjører før hele siden er loadet
document.addEventListener('DOMContentLoaded', 
function main()
{
    //Form validation
   window.validateForm = function()
   {
    var navn = document.forms["bestill_pizza"]["name"].value;           
    var form_pizza = document.forms["bestill_pizza"]["pizza1"].value;
    var adresse = document.forms["bestill_pizza"]["address"].value;
    var num = document.forms["bestill_pizza"]["phone"].value;
    var mail = document.forms["bestill_pizza"]['email'].value;              
    if (navn.length === 0)
        {
            alert("Har du husket å skrive navn?");
            return false;
        }
    else if (form_pizza.length === 0)
        {
            alert('Ser ut som du har glemt å velge pizza :/!');
            return false;
        }
    else if (adresse.length === 0)
        {
            alert('Har du husket å skrive inn adressen din?');
            return false;
        }
    else if (typeof num !=='number' && (num % 1) !== 0)
        {
            alert('Det ser ut som om det er noe galt med nummeret ditt!');
            return false;
        }
    else if (mail.length === 0)
        {
            alert('Du må skrive inn en mail!');
            return false;
        }
    }

    //Legger til ekstra pizzafelt
    var pizza_nr = 1;
    var addFelt = function addPizzafelt()
    {
        if (pizza_nr == 1 || document.forms["bestill_pizza"]["pizza" + String(pizza_nr - 1)].value !== "" )
        {
            //lager feltet og teller pizza
            pizza_nr++;
            var container = document.getElementById('pizzalist');
            var puretxt = document.createTextNode("Pizza nr." + String(pizza_nr));
            var paragr = document.createElement("p");
            paragr.appendChild(puretxt);
            var input = document.createElement("input");
            input.type = "text";
            input.name = "pizza" + String(pizza_nr);
            input.id = "piz" + String(pizza_nr);
            input.size = "15";
            paragr.appendChild(input);
            container.appendChild(paragr);
            eventAdd(); 
        };
    };
    //legger til event listner "focus"
    var eventAdd = function addEventPizza()
    {
        document.getElementById("piz" + String(pizza_nr)).addEventListener("focus", addFelt);   
        //Gjør at det kun er det nederste feltet som generer nytt felt 
        if (pizza_nr > 1)
            {
                document.getElementById("piz" + String(pizza_nr - 1)).removeEventListener("focus", addFelt);
            }

    }

    eventAdd();

}, false);