FROM node:16-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
RUN npx ngcc --properties es2023 browser module main --first-only --create-ivy-entry-points
COPY . .
RUN npm run build


FROM nginx:stable
COPY --from=build /app/dist/todolist-app/ /usr/share/nginx/html
# COPY ./ngnix.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
