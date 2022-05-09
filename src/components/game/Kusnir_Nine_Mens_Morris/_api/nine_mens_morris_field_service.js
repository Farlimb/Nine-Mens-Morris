import gsAxios from "../../../../_api";
const FIELD_URL = `/nine_mens_morris/field`;
const NEW_GAME_URL = FIELD_URL + "/newGame";
const MARK_POS_URL = FIELD_URL + "/markPos";
const REMOVE_POS_URL = FIELD_URL + "/removePos";
const MOVE_POS_URL = FIELD_URL + "/movePos";

const fetchField = () => gsAxios.get(FIELD_URL);
const newGame = () => gsAxios.get(NEW_GAME_URL);

const markPos = (position, player) =>{
    console.log(player);
    return(
    gsAxios.get(`${MARK_POS_URL}?position=${position}&player=${player}`));}

const removePos = (position, player) =>
    gsAxios.get(`${REMOVE_POS_URL}?position=${position}&player=${player}`);
const movePos = (position, positionY, player) =>
    gsAxios.get(`${MOVE_POS_URL}?position=${position}&positionY=${positionY}&player=${player}`);

const fieldService = {fetchField, newGame, markPos, removePos, movePos};
export default fieldService;

