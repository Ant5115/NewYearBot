package tutorial;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {


    public String getBotUsername() {
        return "TutorialBot";
    }

    @Override
    public String getBotToken() {
        return "7641801953:AAFNbzraA6O41AZPCdscuQQiSLdl--ZKAfs";
    }


    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        String message = msg.getText();//сообщение пользователя
        User user = msg.getFrom(); //сам пользователь
        Long id = user.getId(); // id пользователя
        String userName = user.getUserName(); //юзернейм пользователя

        //это ответ бота
        String answer = "";
        String[] mas = message.split(" ");
        int left = 31 - Integer.parseInt(mas[1]);
        answer = "До Нового года осталось: " + left + " дня";




        //оставляем как есть
        SendMessage sm = SendMessage.builder()
                .chatId(id.toString())
                .text(answer) //что будет отвечать бот
                .build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


}
