import {Button, Form} from "react-bootstrap";
import { useForm } from "react-hook-form";
import {addComment} from "../_api/comment.service";
function CommentForm({game,player, onSendComment}){
    const { register, handleSubmit, formState: { errors } } = useForm({mode: "onChange"});
    const onSubmit = data => {
        onSendComment(data.comment);
    }

    return(
        <Form onSubmit={handleSubmit(onSubmit)}>
            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Comment:</Form.Label>
                <input className="form-control"
                       type="text"
                       {...register("comment", {
                           minLength: {value: 3, message: "Minimum is 3 characters."},
                           maxLength: {value: 150, message: "Maximum is 150 characters."},
                           required: {value: true, message: "Comment message is required."},
                       })}
                       placeholder="Enter your comment message here" />
                <Form.Text style={{color: 'red', float: 'right'}}>
                    {errors.comment?.message}
                </Form.Text>
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Comment:</Form.Label>
                <input className="form-control"
                       type="text"
                       {...register("player")}
                       placeholder="Enter your player name here" />
                <Form.Text style={{color: 'red', float: 'right'}}>
                    We'll never share your email with anyone else.
                </Form.Text>
            </Form.Group>
            <Button type="submit">Send</Button>
        </Form>
    );
}

export default CommentForm;