import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';
import {useEffect, useState} from "react";
import {addComment, fetchComments} from "./_api/comment.service";
import Comments from "./components/Comments";
import CommentForm from "./components/CommentForm";
import Scores from "./components/Scores";
import Kusnir_Nine_Mens_morris from "./components/game/Kusnir_Nine_Mens_Morris/Kusnir_Nine_Mens_morris";
import {addScore, fetchScores} from "./_api/score.service";
import Login from "./components/Login";
import RatingForm from "./components/RatingForm";
import {addRating, fetchRating} from "./_api/rating.service";

function App(name) {
    const selectedGame ="nine_mens_morris";
    const [comments, setComments] = useState([]);
    const [rating, setRating] = useState([]);
    const [scores, setScores] = useState([]);
    const loggedPlayer = "Jozo";
    const fetchData = () => {
        fetchRating(selectedGame).then(response =>{
            setRating(response.data);
        })
        fetchComments(selectedGame).then(response => {
            setComments(response.data);
        });
        fetchScores(selectedGame).then(response => {
            setScores(response.data);
        });
    }

    useEffect(() => {
        fetchData();
    }, []);

    const handleSendComment = (comment) => {
        addComment(selectedGame,loggedPlayer,comment).then(response => {
            fetchData();
        });
    }
    const handleSendRating = (rating) => {
        addRating(selectedGame,loggedPlayer,rating).then(response => {
            fetchData();
        });
    }

  return (

    <div className="App container-fluid mt-4 mb-5">
      <h1 align="center">Gamestudio</h1>
        <Login/>
        <Kusnir_Nine_Mens_morris/>
        <h1>Comments</h1>
        <Comments comments={comments}/>
        <h2>Add comment:</h2>
        <CommentForm game={selectedGame} player={loggedPlayer} onSendComment={handleSendComment}/>
        <h1>Scores</h1>
        <Scores scores={scores}/>
        <h1>Average rating {rating}</h1>
        <RatingForm game={selectedGame} player={loggedPlayer} onSendRating={handleSendRating}/>

    </div>
  );
}
export default App;
