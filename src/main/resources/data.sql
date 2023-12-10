INSERT INTO roles(user_role)
VALUES ('USER'),
       ('MODERATOR'),
       ('ADMIN')
ON CONFLICT (user_role) DO NOTHING;

INSERT INTO users(age, email, password, username)
SELECT 20, 'admin@admin.com', '$2a$10$6b.VoCrHD6ShKxGx8HDq8.ioLQ4h.op09vgCPfgHcqqLIeA2UY97e', 'admin'
WHERE NOT EXISTS (SELECT id FROM users WHERE id = 1)
UNION ALL
SELECT 25, 'user@user.com', '$2a$10$6b.VoCrHD6ShKxGx8HDq8.ioLQ4h.op09vgCPfgHcqqLIeA2UY97e', 'user'
WHERE NOT EXISTS (SELECT id FROM users WHERE id = 2)
UNION ALL
SELECT 30, 'test1@user.com', '$2a$10$6b.VoCrHD6ShKxGx8HDq8.ioLQ4h.op09vgCPfgHcqqLIeA2UY97e', 'test1'
WHERE NOT EXISTS (SELECT id FROM users WHERE id = 3)
UNION ALL
SELECT 35, 'test2@user.com', '$2a$10$6b.VoCrHD6ShKxGx8HDq8.ioLQ4h.op09vgCPfgHcqqLIeA2UY97e', 'test2'
WHERE NOT EXISTS (SELECT id FROM users WHERE id = 4)
UNION ALL
SELECT 40, 'test3@user.com', '$2a$10$6b.VoCrHD6ShKxGx8HDq8.ioLQ4h.op09vgCPfgHcqqLIeA2UY97e', 'test3'
WHERE NOT EXISTS (SELECT id FROM users WHERE id = 5);

INSERT INTO users_roles(user_id, role_id)
SELECT 1, 1
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 1)
UNION ALL
SELECT 1, 2
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 1)
UNION ALL
SELECT 1, 3
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 1)
UNION ALL
SELECT 2, 1
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 2)
UNION ALL
SELECT 3, 1
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 3)
UNION ALL
SELECT 4, 1
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 4)
UNION ALL
SELECT 5, 1
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 5);


INSERT INTO manufactures(company_name)
SELECT 'Rockstar'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 1)
UNION ALL
SELECT 'Insomniac Games'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 2)
UNION ALL
SELECT 'Turn 10 Studios'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 3)
UNION ALL
SELECT 'Ubisoft Bordeaux'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 4)
UNION ALL
SELECT 'CD Projekt RED'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 5)
UNION ALL
SELECT 'GSC Game World'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 6)
UNION ALL
SELECT 'Rocksteady Studios'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 7)
UNION ALL
SELECT 'Massive Entertainment'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 8)
UNION ALL
SELECT 'Square Enix'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 9)
UNION ALL
SELECT 'Bandai Namco Studios'
WHERE NOT EXISTS(SELECT id FROM manufactures WHERE id = 9);


INSERT INTO games(rating, release_date, manufacture_id, description, title, img_url)
SELECT 9.5, TO_DATE('2010-11-02', 'YYYY-MM-DD'), 1, 'Grand Theft Auto V is a vast open world game set in Los Santos, ' ||
                                                    'a sprawling sun-soaked metropolis struggling to stay afloat in an era of economic uncertainty and cheap reality TV.' ||
                                                    ' The game blends storytelling and gameplay in new ways as players ' ||
                                                    'repeatedly jump in and out of the lives of the game’s three lead characters, playing all sides of the game’s interwoven story.',
    'GTA5', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700589423/igdb/vqifsqhvwsfgwygpoup9.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 1)
UNION ALL
SELECT 8.8, TO_DATE('2023-10-10', 'YYYY-MM-DD'), 2, 'The incredible power of the symbiote forces Peter and Miles to face the ultimate test of strength,' ||
                                      ' both inside and outside the mask, as they balance their lives, friendships and their duty to protect those in need.',
    'Marvel''s Spider-Man 2', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700589961/igdb/k6pvdt0oq3lreqvsuqya.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 2)
UNION ALL
SELECT 8.1, TO_DATE('2023-10-10', 'YYYY-MM-DD'), 3, 'Out-build the competition in the new career.' ||
                                                       ' Race your friends in adjudicated multiplayer events.' ||
                                                       ' Compete in over 500 cars on world-famous tracks with cutting-edge AI, ' ||
                                                       'advanced physics, tire and fuel strategy, and driver and safety ratings.',
    'Forza Motorsport', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700760616/igdb/zigu4fdswgdukfc7hcte.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 3)
UNION ALL
SELECT 7.2, TO_DATE('2023-10-05', 'YYYY-MM-DD'), 4, 'In the ninth century CE, Baghdad is at its height, ' ||
                                                       'leading the world in science, art, innovation, and commerce.' ||
                                                       ' Amid its bustling urban landscape, a conflicted young orphan ' ||
                                                       'with a tragic past must navigate the streets to survive.',
    'Assassin''s Creed Mirage', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700760616/igdb/zwphvtir9hwmj5rnhxmi.jpg'

WHERE NOT EXISTS(SELECT id FROM games WHERE id = 4)
UNION ALL
SELECT 9.0, TO_DATE('2023-09-26', 'YYYY-MM-DD'), 5, 'Phantom Liberty is a spy-thriller expansion for the open-world action-adventure RPG Cyberpunk 2077.' ||
                                                       ' When the orbital shuttle of the President of the New United States of America ' ||
                                                       'is shot down over the deadliest district of Night City, ' ||
                                                       'there’s only one person who can save her — you. Become V, a cyberpunk for hire,' ||
                                                       ' and dive deep into a tangled web of espionage and political intrigue, ' ||
                                                       'unraveling a story that connects the highest echelons of power with the brutal world of black-market mercenaries.',
    'Cyberpunk 2077: Phantom Liberty', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700760616/igdb/kykutv0pdu2xmjqglkam.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 5);

INSERT INTO games(release_date, manufacture_id, description, title, img_url)
SELECT TO_DATE('2024-01-01', 'YYYY-MM-DD'), 6, 'S.T.A.L.K.E.R 2 is a unique blend of FPS, immersive sim and horror with a really thick atmosphere. ' ||
                                                  'One of the biggest open-worlds to date is yours to explore — along with an epic branching story with multiple endings. ' ||
                                                  'S.T.A.L.K.E.R. stands for (Scavengers, Trespassers, Adventurers, Loners, Killers, Explorers and Robbers).',
    'S.T.A.L.K.E.R. 2: Heart of Chornobyl', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700848778/igdb/zofkiixmcblkgyafw3wz.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 6)
UNION ALL
SELECT TO_DATE('2024-02-02', 'YYYY-MM-DD'), 7, 'The creators of the Batman: Arkham series are back with a brand new action-adventure shooter.' ||
                                                  ' The most dangerous villains in the DC Universe have been forced to team up and take on a new mission: ' ||
                                                  'Kill the Justice League. Create Chaos in Metropolis. You are the Suicide Squad.',
    'Suicide Squad: Kill the Justice League', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700848778/igdb/sewpt8vb6qxm49lbmgda.png'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 7)
UNION ALL
SELECT TO_DATE('2024-03-01', 'YYYY-MM-DD'), 8, 'Experience the first-ever open world Star Wars game,' ||
                                                  ' set between the events of The Empire Strikes Back and Return of the Jedi.' ||
                                                  ' Explore distinct planets across the galaxy, both iconic and new.' ||
                                                  ' Risk it all as Kay Vess, an emerging scoundrel seeking freedom and the means to start a new life, ' ||
                                                  'along with her companion Nix. Fight, steal, and outwit your way through the galaxy’s crime syndicates as you join the galaxy’s most wanted.',
    'Star Wars: Outlaws', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700848778/igdb/mmyjbtqfshdrvnxudydx.png'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 8)
UNION ALL
SELECT TO_DATE('2024-02-29','YYYY-MM-DD'), 9, 'Final Fantasy VII Rebirth is the new story in the Final Fantasy VII remake project, ' ||
                                                 'a reimagining of the iconic original game into three standalone titles by its original creators. ' ||
                                                 'In this game, players will enjoy various new elements as the story unfolds,' ||
                                                 ' culminating in the midpoint from the original Final Fantasy VII.',
    'Final Fantasy VII Rebirth', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700848778/igdb/tyuqhe9gyvnlfhfaynbe.jpg'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 9)
UNION ALL
SELECT TO_DATE('2024-01-25', 'YYYY-MM-DD'), 10, 'The Tekken series is breaking into a new era! ' ||
                                                    'The longest-running story in a video game franchise is coming back' ||
                                                    ' with state-of-the-art graphics and powerful new rivalries. Stay tuned for Tekken 8!',
    'Tekken 8', 'https://res.cloudinary.com/dinjk0zq4/image/upload/v1700848779/igdb/vvertuzfjtw7afgysz38.png'
WHERE NOT EXISTS(SELECT id FROM games WHERE id = 10);


INSERT INTO users_favorite_games(user_id, game_id)
SELECT 1, 1
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1)
UNION ALL
SELECT 1, 2
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1)
UNION ALL
SELECT 1, 3
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1)
UNION ALL
SELECT 1, 4
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1)
UNION ALL
SELECT 1, 5
WHERE NOT EXISTS(SELECT user_id FROM users_favorite_games WHERE user_id = 1);


INSERT INTO game_genre(game_id, genre)
SELECT 1, 'SHOOTER'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 1)
UNION ALL
SELECT 1, 'RPG'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 1)
UNION ALL
SELECT 2, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 2)
UNION ALL
SELECT 3, 'RACING'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 3)
UNION ALL
SELECT 3, 'SPORT'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 3)
UNION ALL
SELECT 4, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 4)
UNION ALL
SELECT 5, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 5)
UNION ALL
SELECT 5, 'RPG'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 5)
UNION ALL
SELECT 5, 'SHOOTER'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 5)
UNION ALL
SELECT 6, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 6)
UNION ALL
SELECT 6, 'RPG'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 6)
UNION ALL
SELECT 6, 'SHOOTER'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 6)
UNION ALL
SELECT 7, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 7)
UNION ALL
SELECT 7, 'SHOOTER'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 7)
UNION ALL
SELECT 8, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 8)
UNION ALL
SELECT 9, 'ADVENTURE'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 9)
UNION ALL
SELECT 9, 'RPG'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 9)
UNION ALL
SELECT 10, 'FIGHTING'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 10);


INSERT INTO platforms(id, name, platform_family, platform_type)
VALUES (1, 'PC (Microsoft Windows)', 'PC', 'PC'),
       (2, 'Playstation 5', 'PLAYSTATION', 'CONSOLE'),
       (3, 'XBOX ONE', 'XBOX', 'CONSOLE'),
       (4, 'Playstation 4', 'PLAYSTATION', 'CONSOLE'),
       (5, 'Xbox Series X|S', 'XBOX', 'CONSOLE')
ON CONFLICT (name) DO NOTHING;

INSERT INTO games_platforms(game_id, platform_id)
SELECT 1, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 1)
UNION ALL
SELECT 1, 3
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 1)
UNION ALL
SELECT 2, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 2)
UNION ALL
SELECT 2, 3
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 2)
UNION ALL
SELECT 3, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 3)
UNION ALL
SELECT 3, 3
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 3)
UNION ALL
SELECT 4, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 4)
UNION ALL
SELECT 4, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 4)
UNION ALL
SELECT 4, 3
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 4)
UNION ALL
SELECT 4, 4
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 4)
UNION ALL
SELECT 4, 5
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 4)
UNION ALL
SELECT 5, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 5)
UNION ALL
SELECT 5, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 5)
UNION ALL
SELECT 5, 5
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 5)
UNION ALL
SELECT 6, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 6)
UNION ALL
SELECT 6, 5
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 6)
UNION ALL
SELECT 7, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 7)
UNION ALL
SELECT 7, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 7)
UNION ALL
SELECT 7, 5
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 7)
UNION ALL
SELECT 8, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 8)
UNION ALL
SELECT 8, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 8)
UNION ALL
SELECT 8, 5
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 8)
UNION ALL
SELECT 9, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 9)
UNION ALL
SELECT 10, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 10)
UNION ALL
SELECT 10, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 10)
UNION ALL
SELECT 10, 5
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 10);


UPDATE games
SET on_focus = true
WHERE id IN (2,3,4,5);

INSERT INTO reviews(created, review, author_id, game_id)
SELECT TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'It is great game!', 1, 1
WHERE NOT EXISTS (SELECT author_id FROM reviews WHERE author_id = 1)
UNION ALL
SELECT TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'You can play it all day long!', 1, 1
WHERE NOT EXISTS (SELECT author_id FROM reviews WHERE author_id = 1)
UNION ALL
SELECT TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'Marvel''s Spider-Man 2 delivers Insomniac''s best tale yet, ' ||
                                               'and despite its open world falling short, is a reliably fun superhero power trip.',
    1, 2
WHERE NOT EXISTS(SELECT author_id FROM reviews WHERE author_id = 1)
UNION ALL
SELECT TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'After nearly a year, Sony is finally releasing another game that I''ll play.',
       1, 2
WHERE NOT EXISTS(SELECT author_id FROM reviews WHERE author_id = 1)
UNION ALL
SELECT TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'Forza Motorsport is brimming with new features across the board, ' ||
                                            'from its muscular new multiplayer to its much-improved handling,' ||
                                            ' but its new RPG-inspired upgrade system feels like a step down.',
       1, 3
WHERE NOT EXISTS(SELECT author_id FROM reviews WHERE author_id = 1)
UNION ALL
SELECT TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'Assassin’s Creed Mirage''s back-to-basics approach is a successful ' ||
                                            'first step in returning to the stealthy style that launched this series.',
       1, 4
WHERE NOT EXISTS(SELECT author_id FROM reviews WHERE author_id = 1)
UNION ALL
SELECT TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'Cyberpunk 2077: Phantom Liberty completes an immense turnaround for CD Projekt Red''s' ||
                                            ' future RPG kickstarted with the anime spinoff, Cyberpunk:' ||
                                            ' Edgerunners and its latest 2.0 Update.',
       1, 5
WHERE NOT EXISTS(SELECT author_id FROM reviews WHERE author_id = 1);
