import gsAxios from "./index";
import {formatDate} from "./utils";


export const fetchRating = game => gsAxios.get('/rating/' + game);

export const addRating = (game, player, rating) => gsAxios.post('/rating', {
    game, player, rating, rated_at: formatDate(new Date()),
});
