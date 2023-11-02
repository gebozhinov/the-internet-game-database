INSERT INTO roles(user_role)
VALUES ('USER'),
       ('MODERATOR'),
       ('ADMIN')
ON CONFLICT (user_role) DO NOTHING;

INSERT INTO users(id, age, email, password, username)
VALUES (1, 33, 'admin@admin.com', 'admin', 'admin')
ON CONFLICT (username) DO NOTHING;

INSERT INTO users_roles(user_id, role_id)
SELECT 1, 1
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 1)
UNION ALL
SELECT 1, 2
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 1)
UNION ALL
SELECT 1, 3
WHERE NOT EXISTS (SELECT user_id FROM users_roles WHERE user_id = 1);

INSERT INTO games(id, rating, release_date, manufacture_id, user_favorites, user_rates, description, title)
VALUES (1, 9.5, '2010-12-12', null, 1, 1, 'Good game!', 'GTA5')
ON CONFLICT (title) DO NOTHING;

INSERT INTO game_genre(game_id, genre)
SELECT 1, 'SHOOTER'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 1)
UNION ALL
SELECT 1, 'RPG'
WHERE NOT EXISTS (SELECT game_id FROM game_genre WHERE game_id = 1);

INSERT INTO manufactures(id, company_name)
VALUES (1, 'Rockstar')
ON CONFLICT (company_name) DO NOTHING;

INSERT INTO platforms(id, name, platform_family, platform_type)
VALUES (1, 'Playstation 5', 'PLAYSTATION', 'CONSOLE'),
       (2, 'XBOX ONE', 'XBOX', 'CONSOLE')
ON CONFLICT (name) DO NOTHING;

INSERT INTO games_platforms(game_id, platform_id)
SELECT 1, 1
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 1)
UNION ALL
SELECT 1, 2
WHERE NOT EXISTS (SELECT game_id FROM games_platforms WHERE game_id = 1);

INSERT INTO reviews(id, created, review, author_id, game_id)
SELECT 1, TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'It is great game!', 1, 1
WHERE NOT EXISTS (SELECT author_id FROM reviews WHERE author_id = 1)
UNION ALL
SELECT 2, TO_DATE('2023-11-02', 'YYYY-MM-DD'), 'You can play it all day long!', 1, 1
WHERE NOT EXISTS (SELECT author_id FROM reviews WHERE author_id = 1);