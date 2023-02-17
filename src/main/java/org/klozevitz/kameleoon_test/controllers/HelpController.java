package org.klozevitz.kameleoon_test.controllers;

import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoQuote;
import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoUser;
import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoVote;
import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.User;
import org.klozevitz.kameleoon_test.model.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/test")
public class HelpController {
    @Autowired
    IDaoUser userDao;
    @Autowired
    IDaoQuote quoteDao;
    @Autowired
    IDaoVote voteDao;

    @GetMapping("/generateBase")
    public String generateBase() {
        if (userDao.findById(1).getId() == -1L)
            generateUserTable();
        if (quoteDao.findById(1).getId() == -1L)
            generateQuoteTable();
        if (voteDao.findById(1).getId() == -1L)
            generateVoteTable();
        return "done";
    }

    private void generateUserTable() {
        String[] users = {"Anna", "Bob", "Claus", "Rick", "Rob"};
        LocalDate date = LocalDate.now();
        for (String name : users) {
            if (Math.random() > 0.5) {
                date = date.plusDays((int) (Math.random() * 10));
            }
            userDao.save(generateUser(name, date));
        }
    }

    private User generateUser(String name, LocalDate date) {
        User user;
        String email;
        if (Math.random() > 0.5) {
            email = name.concat("@gmail.com");
            user = new User(name, email, name);
        } else {
            user = new User(name, name);
        }
        user.setRegistered(date);
        return user;
    }

    private void generateQuoteTable() {
        String[] quotes = {
                "Менее всего просты люди желающие казаться простыми.",
                "Если человек не нашёл, за что может умереть, он не способен жить.",
                "Если кто-то причинил тебе зло, не мсти. Сядь на берегу реки, и вскоре ты увидишь, как мимо тебя проплывает труп твоего врага.",
                "Мой способ шутить – это говорить правду. На свете нет ничего смешнее.",
                "История – самый лучший учитель, у которого самые плохие ученики.",
                "Мышление – верх блаженства и радость жизни, доблестнейшее занятие человека.",
                "Чем больше любви, мудрости, красоты, доброты вы откроете в самом себе, тем больше вы заметите их в окружающем мире.",
                "Некоторые люди проводят жизнь в поисках любви вне их самих... Пока любовь в моём сердце, она повсюду.",
                "Фантазия мужчины – лучшее оружие женщины.",
                "Есть люди, у которых есть деньги, и есть богатые люди.",
                "Быть самым богатым человеком на кладбище для меня не важно… Ложиться спать и говорить себе, что сделал действительно нечто прекрасное, — вот что важно!",
                "Вы знаете, чем отличаются богатые и бедные? Бедные продают наркотики, чтобы покупать себе найки, в то время, как богатые продают эти найки, чтобы покупать себе наркотики.",
                "Чем умнее человек, тем легче он признает себя дураком.",
                "Внимай лишь одному учителю – Природе.",
                "То, что мы знаем, это капля, а то, что мы не знаем, это океан.",
                "Знание — это абсолютная ценность нашего времени…",
                "Человек совершал бы меньше ошибок, если бы знал, чего именно он не знает.",
                "Знание, далекое от справедливости, заслуживает скорее названия ловкости, чем мудрости.",
                "Никогда не ошибается тот, кто ничего не делает.",
                "Если тебе тяжело, значит ты поднимаешься в гору. Если тебе легко, значит ты летишь в пропасть.",
                "Единственный человек, с которым вы должны сравнивать себя, – это вы в прошлом. И единственный человек, лучше которого вы должны быть, – это вы сейчас.",
                "Дай человеку власть, и ты узнаешь, кто он.",
                "Я серьёзно отношусь к своей работе, а это возможно только при несерьёзном отношении к собственной персоне.",
                "Многие люди не представляют, как близко они подобрались к успеху в тот момент, когда сдались",
                "Музыка заводит сердца так, что пляшет и поёт тело. А есть музыка, с которой хочется поделиться всем, что наболело.",
                "Невозможность писать для меня равносильна погребению заживо...",
                "Необходимо, чтобы художник, кроме глаза, воспитывал и свою душу.",
                "Любите искусство в себе, а не себя в искусстве.",
                "Искусство заключается в том, чтобы найти необыкновенное в обыкновенном и обыкновенное в необыкновенном.",
                "Лондонские туманы не существовали, пока их не открыло искусство.",
                "Характер – это и есть судьба.",
                "Перспектива рано умереть заставила меня понять, что жизнь стоит того, чтобы её прожить.",
                "Когда-нибудь не страшно умереть – страшно умереть вот сейчас.",
                "Научить людей ценить жизнь» — с этой задачей лучше всего справляется смерть.",
                "Из моих останков вырастут цветы, и я буду в них — это и есть вечность!",
                "Когда кто-то слишком долго ходит между жизнью и смертью, он начинает чувствовать себя живым, лишь когда смерть дышит ему в затылок."
        };
        List<User> users = userDao.findAll();
        int quotesAmount;
        LocalDate date;
        int counter = 0;
        for (User user: users) {
            date = user.getRegistered();
            quotesAmount = (int) (Math.random() * 12);
            for (int i = 0; i < quotesAmount; i++) {
                if (Math.random() > 0.3) {
                    date = date.plusDays((int) (Math.random() * 10));
                }
                Quote quote = new Quote(quotes[counter], user);
                quote.setUpdated(date);
                quoteDao.save(quote);
                counter++;
            }
        }
    }

    private void generateVoteTable() {
        int voteAmount;
        LocalDate date;
        double rate;
        List<Quote> quotes = quoteDao.findAll();
        for (Quote quote: quotes) {
            rate = Math.random();
            voteAmount = (int) (Math.random() * 30);
            date = quote.getUpdated();
            for(int i = 0; i < voteAmount; i++) {
                Vote vote = new Vote(true, quote);
                if (Math.random() > rate) {
                    vote.setVote(false);
                }
                if (Math.random() > 0.8) {
                    date = date.plusDays((int) (Math.random() * 3));
                }
                vote.setDate(date);
                voteDao.save(vote);
            }
        }
    }
}
