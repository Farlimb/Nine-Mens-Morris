import gsAxios from "./index";
import {formatDate} from "./utils";

//get api/score/mines
export const fetchScores = game => gsAxios.get('/score/' + game);
export const addScore = (game,player,points) => gsAxios.post('/score', {
    game, player, points, playedAt: formatDate(new Date()),
});