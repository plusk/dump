// Endrer klassen slik at dropdown-meny blir synlig
function rolloverMenu(showHide, menu)
{
    var menuObj = document.getElementById(menu);
    if (showHide == 0)
    {
        menuObj.style.display = 'none';
    }
    else
    {
        menuObj.style.display = 'block';
    }
}